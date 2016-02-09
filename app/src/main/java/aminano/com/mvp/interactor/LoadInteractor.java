package aminano.com.mvp.interactor;

import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.SharedPreferencesRepository;

/**
 * Created by Usuario on 18/11/2015.
 */
public class LoadInteractor extends MainInteractor {

  public LoadInteractor(SharedPreferencesRepository sharedPreferencesRepository) {
    super(sharedPreferencesRepository);
  }

  public void loadSharedPreferences(final MainPresenterListener listener) {
    runUiThread(listener);
  }

  @Override
  public void action(MainPresenterListener listener) {
    listener.onSuccessLoad(sharedPreferencesRepository.loadString());
  }
}
