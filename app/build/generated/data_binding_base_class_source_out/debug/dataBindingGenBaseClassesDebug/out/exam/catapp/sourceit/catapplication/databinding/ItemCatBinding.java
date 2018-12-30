package exam.catapp.sourceit.catapplication.databinding;

import android.databinding.Bindable;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import exam.catapp.sourceit.catapplication.model.Cat;

public abstract class ItemCatBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textViewBreed;

  @NonNull
  public final TextView textViewName;

  @Bindable
  protected Cat mCat;

  protected ItemCatBinding(DataBindingComponent _bindingComponent, View _root, int _localFieldCount,
      ImageView imageView, TextView textViewBreed, TextView textViewName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textViewBreed = textViewBreed;
    this.textViewName = textViewName;
  }

  public abstract void setCat(@Nullable Cat cat);

  @Nullable
  public Cat getCat() {
    return mCat;
  }

  @NonNull
  public static ItemCatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCatBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root,
      boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCatBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.item_cat, root, attachToRoot, component);
  }

  @NonNull
  public static ItemCatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemCatBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.item_cat, null, false, component);
  }

  public static ItemCatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemCatBinding bind(@NonNull View view, @Nullable DataBindingComponent component) {
    return (ItemCatBinding)bind(component, view, exam.catapp.sourceit.catapplication.R.layout.item_cat);
  }
}
