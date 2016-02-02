package aminano.com.mvp.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Usuario on 17/11/2015.
 */
public class SharedPreferencesRepository implements Repository {
    private Context context;
    private SharedPreferences.Editor prefs;

    public SharedPreferencesRepository(Context context) {
        this.context = context;
    }

    @Override
    public void saveString(String text) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context).edit();
        prefs.putString("text", text);
        prefs.apply();
    }

    @Override
    public String loadString() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String name = preferences.getString("text", "");
        return name;
    }
}
