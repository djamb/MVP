package aminano.com.mvp.interactor;

import aminano.com.mvp.App;
import aminano.com.mvp.R;
import aminano.com.mvp.presenter.MainPresenterListener;
import aminano.com.mvp.repository.Repository;
import android.text.TextUtils;

/**
 * Created by Usuario on 18/11/2015.
 */
public class SaveInteractor extends MainInteractor {
  private String text;

  public SaveInteractor(Repository repository) {
    super(repository);
  }

  public void saveString(String text, final MainPresenterListener listener) {
    this.text = text;
    runUiThread(listener);
  }

  @Override
  public void action(final MainPresenterListener listener) {
    if (TextUtils.isEmpty(text) || TextUtils.equals(text,
        App.getContext().getResources().getString(R.string.ass)) || TextUtils.equals(text,
        App.getContext().getResources().getString(R.string.monkey))) {
      listener.onError(text);
    } else {
      repository.saveString(text);
      listener.onSuccessSave();
    }
  }
}
