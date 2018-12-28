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

public abstract class FragmentCatBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textViewAge;

  @NonNull
  public final TextView textViewBreed;

  @NonNull
  public final TextView textViewDescription;

  @NonNull
  public final TextView textViewName;

  @Bindable
  protected Cat mCat;

  protected FragmentCatBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView, TextView textViewAge, TextView textViewBreed,
      TextView textViewDescription, TextView textViewName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textViewAge = textViewAge;
    this.textViewBreed = textViewBreed;
    this.textViewDescription = textViewDescription;
    this.textViewName = textViewName;
  }

  public abstract void setCat(@Nullable Cat cat);

  @Nullable
  public Cat getCat() {
    return mCat;
  }

  @NonNull
  public static FragmentCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCatBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.fragment_cat, root, attachToRoot, component);
  }

  @NonNull
  public static FragmentCatBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static FragmentCatBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<FragmentCatBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.fragment_cat, null, false, component);
  }

  public static FragmentCatBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static FragmentCatBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (FragmentCatBinding)bind(component, view, exam.catapp.sourceit.catapplication.R.layout.fragment_cat);
  }
}
