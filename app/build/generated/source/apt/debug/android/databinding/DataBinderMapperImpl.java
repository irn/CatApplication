package android.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new exam.catapp.sourceit.catapplication.DataBinderMapperImpl());
  }
}
