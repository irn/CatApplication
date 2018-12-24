package exam.catapp.sourceit.catapplication.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import exam.catapp.sourceit.catapplication.R;
import exam.catapp.sourceit.catapplication.databinding.ItemCatBinding;
import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 07.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatAdapter extends CursorAdapter {

    private OnCatClickListener listener;

    public CatAdapter(Context context, Cursor c, boolean autoRequery, OnCatClickListener clickListener) {
        super(context, c, autoRequery);
        listener = clickListener;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        ItemCatBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_cat, viewGroup, false);
        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, final Cursor cursor) {

        ItemCatBinding binding = DataBindingUtil.bind(view);

        int id = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_ID));
        int age = cursor.getInt(cursor.getColumnIndex(Cat.COLUMN_AGE));
        String name = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_NAME));
        String breed = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_BREED));
        String imageUrl = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_IMAGE_URL));
        String description = cursor.getString(cursor.getColumnIndex(Cat.COLUMN_DESCRIPTION));

        final Cat cat = new Cat();
        cat.setId(id);
        cat.setAge(age);
        cat.setName(name);
        cat.setBreed(breed);
        cat.setImageUrl(imageUrl);
        cat.setDescription(description);

        binding.setCat(cat);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null){
                    listener.onCatClick(cat, cursor.getPosition());
                }
            }
        });

    }

    @BindingAdapter("loadImageUrl")
    public static void setImageUrl(ImageView imageView, String url){
        Picasso.with(imageView.getContext()).load(url).into(imageView);
    }
}
