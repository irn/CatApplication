package exam.catapp.sourceit.catapplication;


import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import exam.catapp.sourceit.catapplication.database.CatDatabase;
import exam.catapp.sourceit.catapplication.databinding.FragmentCatBinding;
import exam.catapp.sourceit.catapplication.model.Cat;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatFragment extends Fragment {

    private FragmentCatBinding binding;

    private CatDatabase catDatabase;

    private int id = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null){
            id = getArguments().getInt("id");
        }

        catDatabase = Room.databaseBuilder(getContext(), CatDatabase.class, "cats.db").build();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.
                inflate(inflater, R.layout.fragment_cat, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        catDatabase.catDao().getCat(id).observe(this, new Observer<Cat>() {
            @Override
            public void onChanged(@Nullable Cat cat) {
                binding.setCat(cat);
            }
        });
    }
}
