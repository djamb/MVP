package aminano.com.mvp;

import android.app.Application;
import android.content.Context;

/**
 * @author Antonio Miñano
 */
public class App extends Application {

  private static Context mContext;

  @Override
  public void onCreate() {
    super.onCreate();
    mContext = this;
  }

  public static Context getContext(){
    return mContext;
  }
}
