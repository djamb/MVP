package aminano.com.mvp.interactor;

import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.Repository;
import android.os.Handler;

/**
 * Created by Usuario on 14/11/2015.
 */
public abstract class MainInteractor {

  Repository repository;

  public MainInteractor(Repository repository) {
    this.repository = repository;
  }

  public void runUiThread(final MainPresenterListener listener) {
    new Handler().postDelayed(new Runnable() {
      @Override
      public void run() {
        action(listener);
      }
    }, 3000);
  }

  public abstract void action(final MainPresenterListener listener);
}
