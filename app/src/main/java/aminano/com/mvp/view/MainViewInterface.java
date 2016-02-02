package aminano.com.mvp.view;

/**
 * Created by Usuario on 14/11/2015.
 */
public interface MainViewInterface {
    void enableLoading();

    void disableLoading();

    void dialogError(String text);

    void loadSharedPreferences(String text);
}
