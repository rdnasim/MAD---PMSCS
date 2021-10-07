package pro.rdnasim.madpmscs.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import pro.rdnasim.madpmscs.R;

public class VisitingCardActivity extends AppCompatActivity {

    TextView callPhone, website, address, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visiting_card);

        callPhone = findViewById(R.id.textPhone);
        website = findViewById(R.id.textWebsite);
        address = findViewById(R.id.textAddress);
        mail = findViewById(R.id.textEmail);

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

        address.setOnClickListener(v -> {
            String uri = "https://goo.gl/maps/tYgzMbEPYtPBN6SV7";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });

        mail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:riadul@banglafire.com"));
            startActivity(Intent.createChooser(emailIntent, "Send feedback"));
        });
    }
}