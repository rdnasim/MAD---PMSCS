package pro.rdnasim.madpmscs.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import pro.rdnasim.madpmscs.R;

public class MainActivity extends AppCompatActivity {

    Button visitingCardBtn, spinnerBtn, stopWatchActivityBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visitingCardBtn = findViewById(R.id.visiting_card);
        spinnerBtn = findViewById(R.id.spinner_select);
        stopWatchActivityBtn = findViewById(R.id.stopwatch_activity);

        visitingCardBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, VisitingCardActivity.class);
            startActivity(intent);
        });

        spinnerBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SpinnerSelectionActivity.class);
            startActivity(intent);
        });

        stopWatchActivityBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StopWatchActivity.class);
            startActivity(intent);
        });
    }
}