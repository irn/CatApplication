package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new sourceit.android.catapp.DataBinderMapperImpl());
  }
}
