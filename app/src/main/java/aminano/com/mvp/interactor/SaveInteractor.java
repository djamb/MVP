package aminano.com.mvp.interactor;

import aminano.com.mvp.App;
import aminano.com.mvp.R;
import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.SharedPreferencesRepository;
import android.text.TextUtils;

/**
 * Created by Usuario on 18/11/2015.
 */
public class SaveInteractor extends MainInteractor {
  private String text;

  public SaveInteractor(SharedPreferencesRepository sharedPreferencesRepository) {
    super(sharedPreferencesRepository);
  }

  public void saveSharedPreferences(String text, final MainPresenterListener listener) {
    this.text = text;
    runUiThread(listener);
  }

  public void action(final MainPresenterListener listener) {
    if (TextUtils.isEmpty(text) || TextUtils.equals(text,
        App.getContext().getResources().getString(R.string.ass)) || TextUtils.equals(text,
        App.getContext().getResources().getString(R.string.pussy))) {
      listener.onError(text);
    } else {
      sharedPreferencesRepository.saveString(text);
      listener.onSuccessSave();
    }
  }
}
