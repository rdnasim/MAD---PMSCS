package pro.rdnasim.madpmscs.activity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import pro.rdnasim.madpmscs.R;
import pro.rdnasim.madpmscs.util.CustomToast;

public class StopWatchActivity extends AppCompatActivity {

    Button startBtn, stopBtn, resetBtn;
    String tag = "LifeCycleEvents";
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        startBtn = findViewById(R.id.start_button);
        stopBtn = findViewById(R.id.stop_button);
        resetBtn = findViewById(R.id.reset_button);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

        //what the scenario after button pressing
        btnPressingActivity();
    }

    private void btnPressingActivity() {
        //Start the stopwatch running when the Start button is clicked.
        startBtn.setOnClickListener(v -> running = true);

        //Stop the stopwatch running when the Stop button is clicked.
        stopBtn.setOnClickListener(v -> running = false);

        //Reset the stopwatch when the Reset button is clicked.
        resetBtn.setOnClickListener(v -> {
            running = false;
            seconds = 0;
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
        new CustomToast(getApplicationContext(), "onResume Activity Running").show();
        //Toast.makeText(getApplicationContext(), "onResume the activity.", Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
        new CustomToast(getApplicationContext(), "onPause the activity.").show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        new CustomToast(getApplicationContext(), "onRestart the activity.").show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        new CustomToast(getApplicationContext(), "onPostResume the activity.").show();

    }

    @Override
    protected void onStart() {
        super.onStart();
        running = true;
        new CustomToast(getApplicationContext(), "onStart Activity Running").show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        new CustomToast(getApplicationContext(), "onStop the activity.").show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new CustomToast(getApplicationContext(), "onDestroy the activity.").show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        new CustomToast(getApplicationContext(), "onBackPress the activity.").show();
    }

    //Sets the number of seconds on the timer.
    private void runTimer() {
        final TextView timeView = findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}