package exam.catapp.sourceit.catapplication.databinding;
import exam.catapp.sourceit.catapplication.R;
import exam.catapp.sourceit.catapplication.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemCatBindingImpl extends ItemCatBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.support.constraint.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemCatBindingImpl(@Nullable android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemCatBindingImpl(android.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.TextView) bindings[2]
            );
        this.imageView.setTag(null);
        this.mboundView0 = (android.support.constraint.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.textViewBreed.setTag(null);
        this.textViewName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.cat == variableId) {
            setCat((exam.catapp.sourceit.catapplication.model.Cat) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setCat(@Nullable exam.catapp.sourceit.catapplication.model.Cat Cat) {
        this.mCat = Cat;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.cat);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String catBreed = null;
        java.lang.String catName = null;
        java.lang.String catImageUrl = null;
        exam.catapp.sourceit.catapplication.model.Cat cat = mCat;

        if ((dirtyFlags & 0x3L) != 0) {



                if (cat != null) {
                    // read cat.breed
                    catBreed = cat.getBreed();
                    // read cat.name
                    catName = cat.getName();
                    // read cat.imageUrl
                    catImageUrl = cat.getImageUrl();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            exam.catapp.sourceit.catapplication.adapter.CatAdapter.setImageUrl(this.imageView, catImageUrl);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textViewBreed, catBreed);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.textViewName, catName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): cat
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}