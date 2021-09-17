package pro.rdnasim.madpmscs.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import pro.rdnasim.madpmscs.R;
import pro.rdnasim.madpmscs.base.BaseActivity;

public class DivDisUpoDetailsActivity extends BaseActivity {

    TextView title, division, district, upozilla, coordinate;
    Button openMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_dis_upo_details);

        title = findViewById(R.id.title);
        division = findViewById(R.id.divisionTextView);
        district = findViewById(R.id.districtTextView);
        upozilla = findViewById(R.id.upozillaTextView);
        coordinate = findViewById(R.id.coordinateTextView);

        title.setText(String.format("Details about %s", appStorage.getDistrict()));
        division.setText(String.format("Division Name: %s", appStorage.getDivisionName()));
        district.setText(String.format("District Name: %s", appStorage.getDistrict()));
        upozilla.setText(String.format("Upozilla Name: %s", appStorage.getUpozillahName()));
        coordinate.setText(String.format("Coordinate: %s", appStorage.getCoordinate()));

        openMap = findViewById(R.id.findLocation);

        openMap.setOnClickListener(v -> {
            String uri = "https://www.google.com/maps/place/" + appStorage.getCoordinate();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            startActivity(intent);
        });
    }
}