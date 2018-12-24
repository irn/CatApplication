package exam.catapp.sourceit.catapplication.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import exam.catapp.sourceit.catapplication.R;
import exam.catapp.sourceit.catapplication.databinding.ItemCatBinding;
import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatRecycleAdapter extends RecyclerView.Adapter<CatRecycleAdapter.CatViewHolder> {

    private List<Cat> catList;

    private OnCatClickListener catClickListener;

    public CatRecycleAdapter(List<Cat> cats, OnCatClickListener clickListener){
        catList = cats;
        catClickListener = clickListener;

    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        ItemCatBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_cat, viewGroup, false);
        return new CatViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder catViewHolder, final int i) {
        ItemCatBinding binding = DataBindingUtil.bind(catViewHolder.itemView);
        final Cat cat = catList.get(i);
        binding.setCat(cat);
        binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (catClickListener != null){
                    catClickListener.onCatClick(cat, i);
                }
            }
        });
        binding.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return catList != null ? catList.size() : 0;
    }

    static class CatViewHolder extends RecyclerView.ViewHolder {

        public CatViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}


