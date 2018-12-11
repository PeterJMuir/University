import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DBSettings {
    private String DBURL;
    private String userName;
    private String password;

    public String getDBURL() {
        return DBURL;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
