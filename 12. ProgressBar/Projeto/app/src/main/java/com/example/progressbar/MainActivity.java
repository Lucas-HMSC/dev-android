package com.example.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pgHoriz, pgCirc;
    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pgHoriz = findViewById(R.id.pgHorizontal);
        pgCirc  = findViewById(R.id.pgCirc);

        pgCirc.setVisibility(View.GONE);
    }

    public void carregarProgressBar(View view){
        // ProgressBar Horizontal
        this.progress++;
        pgHoriz.setProgress(this.progress);

        //ProgressBar Circular
        pgCirc.setVisibility(View.VISIBLE);

        if (this.progress == 10){
            pgCirc.setVisibility(View.GONE);
        }
    }
}
