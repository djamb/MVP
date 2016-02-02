package aminano.com.mvp.repository;

/**
 * Created by Usuario on 17/11/2015.
 */
public interface Repository {
    void saveString(String text);

    String loadString();
}
