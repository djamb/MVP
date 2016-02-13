package aminano.com.mvp.presenter;

import aminano.com.mvp.interactor.LoadInteractor;
import aminano.com.mvp.interactor.SaveInteractor;
import aminano.com.mvp.view.MainViewInterface;

/**
 * Created by Usuario on 14/11/2015.
 */
public class MainPresenter implements MainPresenterInterface, MainPresenterListener {
  private MainViewInterface mainView;
  private SaveInteractor saveInteractor;
  private LoadInteractor loadInteractor;

  public MainPresenter(MainViewInterface mainView, SaveInteractor saveInteractor,
      LoadInteractor loadInteractor) {
    this.mainView = mainView;
    this.saveInteractor = saveInteractor;
    this.loadInteractor = loadInteractor;
  }

  @Override
  public void doActionSave(String storeString) {
    mainView.enableLoading();
    saveInteractor.saveString(storeString, this);
  }

  @Override
  public void doActionLoad() {
    mainView.enableLoading();
    loadInteractor.loadString(this);
  }

  @Override
  public void onSuccessSave() {
    mainView.disableLoading();
  }

  @Override
  public void onError(String text) {
    mainView.disableLoading();
    mainView.dialogError(text);
  }

  @Override
  public void onSuccessLoad(String text) {
    mainView.disableLoading();
    mainView.showText(text);
  }
}
