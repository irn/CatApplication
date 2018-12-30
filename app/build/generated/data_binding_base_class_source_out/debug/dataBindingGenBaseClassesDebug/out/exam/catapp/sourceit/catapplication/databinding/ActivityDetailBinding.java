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

public abstract class ActivityDetailBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView;

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

  protected ActivityDetailBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount, ImageView imageView, TextView textView, TextView textViewAge,
      TextView textViewBreed, TextView textViewDescription, TextView textViewName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imageView = imageView;
    this.textView = textView;
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
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.activity_detail, root, attachToRoot, component);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ActivityDetailBinding>inflate(inflater, exam.catapp.sourceit.catapplication.R.layout.activity_detail, null, false, component);
  }

  public static ActivityDetailBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ActivityDetailBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ActivityDetailBinding)bind(component, view, exam.catapp.sourceit.catapplication.R.layout.activity_detail);
  }
}
