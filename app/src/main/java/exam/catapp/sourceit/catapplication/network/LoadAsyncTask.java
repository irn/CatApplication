package exam.catapp.sourceit.catapplication.network;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exam.catapp.sourceit.catapplication.database.CatDatabase;
import exam.catapp.sourceit.catapplication.model.Cat;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class LoadAsyncTask extends AsyncTask<Void, Void, List<Cat>> {

    private CatLoadingListener loadingListener;

    private Context context;

    public LoadAsyncTask(Context context, CatLoadingListener listener){
        this.context = context;
        loadingListener = listener;
    }

    @Override
    protected void onPreExecute() {
        if (loadingListener != null) {
            loadingListener.startLoading();
        }
    }

    @Override
    protected List<Cat> doInBackground(Void... voids) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Cat> catList = null;

        CatDatabase catDatabase = initializeDatabase();
        catList = catDatabase.catDao().getAll();

        if (catList == null || catList.size() == 0){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://sampleandorid.firebaseio.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            CatService catService = retrofit.create(CatService.class);
            try {
                Response<List<Cat>> response = catService.getAllCats().execute();
                catList = response.body();
                List<Cat> result = new ArrayList<>();
                for (Cat cat : catList) {
                    if (cat != null){
                        result.add(cat);
                    }
                }
                catList = result;

                catDatabase.catDao().insertCat(catList);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return catList;
    }

    private CatDatabase initializeDatabase(){
        CatDatabase catDatabase = Room.
                databaseBuilder(context, CatDatabase.class, "cats.db").
                build();
        return catDatabase;

    }

    @Override
    protected void onPostExecute(List<Cat> cats) {
        if (loadingListener != null) {
            loadingListener.finishLoading(cats);
        }
    }
}
