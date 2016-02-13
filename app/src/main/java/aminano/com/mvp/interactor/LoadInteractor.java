package aminano.com.mvp.interactor;

import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.Repository;

/**
 * Created by Usuario on 18/11/2015.
 */
public class LoadInteractor extends MainInteractor {

  public LoadInteractor(Repository repository) {
    super(repository);
  }

  public void loadString(final MainPresenterListener listener) {
    runUiThread(listener);
  }

  @Override
  public void action(MainPresenterListener listener) {
    listener.onSuccessLoad(repository.loadString());
  }
}
