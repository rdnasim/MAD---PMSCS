package pro.rdnasim.madpmscs.base;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import pro.rdnasim.madpmscs.R;


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
