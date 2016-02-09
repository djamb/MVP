package aminano.com.mvp.repository;

import aminano.com.mvp.App;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Usuario on 17/11/2015.
 */
public class SharedPreferencesRepository implements Repository {
  private SharedPreferences.Editor prefs;

  @Override
  public void saveString(String text) {
    prefs = PreferenceManager.getDefaultSharedPreferences(App.getContext()).edit();
    prefs.putString("text", text);
    prefs.apply();
  }

  @Override
  public String loadString() {
    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(App.getContext());
    String name = preferences.getString("text", "");
    return name;
  }
}
