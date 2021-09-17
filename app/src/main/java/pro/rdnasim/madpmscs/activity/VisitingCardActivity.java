package pro.rdnasim.madpmscs.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import pro.rdnasim.madpmscs.R;

public class VisitingCardActivity extends AppCompatActivity {

    TextView callPhone, website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiting_card);

        callPhone = findViewById(R.id.textPhone);
        website = findViewById(R.id.textWebsite);

        callPhone.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:01521305745"));
            startActivity(intent);
        });


        website.setOnClickListener(v -> {
            Uri uri = Uri.parse("http://www.banglafire.com"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}