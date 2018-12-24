package exam.catapp.sourceit.catapplication.network;

import java.util.List;

import exam.catapp.sourceit.catapplication.model.Cat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public interface CatService {

    @GET(".json")
    Call<List<Cat>> getAllCats();
}
