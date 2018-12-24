package exam.catapp.sourceit.catapplication.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import exam.catapp.sourceit.catapplication.CatFragment;
import exam.catapp.sourceit.catapplication.model.Cat;


/**
 * Created by Ruslan Ivakhnenko on 17.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public class CatFragmentAdapter extends FragmentStatePagerAdapter {

    private List<Cat> catList;

    public CatFragmentAdapter(FragmentManager fm, List<Cat> cats) {
        super(fm);
        catList = cats;
    }

    @Override
    public Fragment getItem(int i) {

        Cat cat = catList.get(i);
        CatFragment catFragment = new CatFragment();
        Bundle args = new Bundle();
        args.putInt("id", cat.getId());
        catFragment.setArguments(args);

        return catFragment;
    }

    @Override
    public int getCount() {
        return catList != null ? catList.size() : 0;
    }
}
