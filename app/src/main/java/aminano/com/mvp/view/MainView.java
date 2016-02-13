package aminano.com.mvp.view;

import aminano.com.mvp.R;
import aminano.com.mvp.interactor.LoadInteractor;
import aminano.com.mvp.interactor.SaveInteractor;
import aminano.com.mvp.presenter.MainPresenter;
import aminano.com.mvp.repository.Repository;
import aminano.com.mvp.repository.SharedPreferencesRepository;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainView extends Activity implements MainViewInterface, Button.OnClickListener {
  private MainPresenter mainPresenter;
  private ProgressBar progressBar;
  private LoadInteractor loadInteractor;
  private SaveInteractor saveInteractor;
  private Repository repository;
  private EditText editText;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    progressBar = (ProgressBar) findViewById(R.id.progressBar);
    editText = (EditText) findViewById(R.id.editText);
    findViewById(R.id.button).setOnClickListener(this);

    // Create repository
    repository = new SharedPreferencesRepository();
    // Create interactors
    loadInteractor = new LoadInteractor(repository);
    saveInteractor = new SaveInteractor(repository);
    // Create presenter
    mainPresenter = new MainPresenter(this, saveInteractor, loadInteractor);
    // Show loading
    mainPresenter.doActionLoad();
  }

  @Override
  public void enableLoading() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void disableLoading() {
    progressBar.setVisibility(View.INVISIBLE);
  }

  @Override
  public void showText(String text) {
    editText.setText(text);
  }

  @Override
  public void dialogError(String text) {
    new AlertDialog.Builder(this).setTitle(R.string.wrong_word)
        .setMessage(text)
        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int which) {
            editText.setText("");
          }
        })
        .setIcon(android.R.drawable.ic_dialog_alert)
        .show();
  }

  @Override
  public void onClick(View v) {
    mainPresenter.doActionSave(editText.getText().toString());
  }
}
