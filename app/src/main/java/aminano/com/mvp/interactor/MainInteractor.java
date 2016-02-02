package aminano.com.mvp.interactor;

import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.SharedPreferencesRepository;
import android.os.Handler;

/**
 * Created by Usuario on 14/11/2015.
 */
public abstract class MainInteractor {

    SharedPreferencesRepository sharedPreferencesRepository;

    public MainInteractor(SharedPreferencesRepository sharedPreferencesRepository) {
        this.sharedPreferencesRepository = sharedPreferencesRepository;
    }

    public void runUiThread(final MainPresenterListener listener){
      new Handler().postDelayed(new Runnable() {
        @Override public void run() {
          action(listener);
        }
      }, 3000);
    }
    public abstract void action(final MainPresenterListener listener);
  //public void runUiThread(final Callback callback){
  //  new Handler().postDelayed(new Runnable() {
  //    @Override public void run() {
  //      action(callback);
  //    }
  //  }, 3000);
  //}
  //public abstract void action(final Callback callback);
  //
  //interface Callback {
  //  void onSuccess();
  //  void onError(Throwable throwable);
  //}
}
