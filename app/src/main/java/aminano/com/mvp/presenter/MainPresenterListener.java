package aminano.com.mvp.presenter;

/**
 * Created by Usuario on 15/11/2015.
 */
public interface MainPresenterListener {

    void onError(String text);

    void onSuccessSave();

    void onSuccessLoad(String text);
}
