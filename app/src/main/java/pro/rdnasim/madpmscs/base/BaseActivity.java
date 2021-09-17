package pro.rdnasim.madpmscs.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class BaseActivity extends AppCompatActivity {

    public BaseApplication mInstance;
    public AppStorage appStorage;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mInstance = BaseApplication.getInstance();
        AppEngine appEngine = AppEngine.getInstance();
        appStorage = appEngine.appStorage;
    }
}
