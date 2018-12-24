package exam.catapp.sourceit.catapplication.network;

import java.util.List;

import exam.catapp.sourceit.catapplication.model.Cat;

/**
 * Created by Ruslan Ivakhnenko on 10.12.2018.
 * <p>
 * e-mail: ruslan1910@gmail.com
 */
public interface CatLoadingListener {

    void startLoading();

    void finishLoading(List<Cat> cats);
}
