package com.example.thecourt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addThreeA(View view) {
        scoreA+=3;
        displayA(scoreA);

    }

    private void displayA(int scoreA) {
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(""+scoreA);
    }

    public void addTwoA(View view) {
        scoreA+=2;
        displayA(scoreA);
    }

    public void freeA(View view) {
        scoreA+=1;
        displayA(scoreA);
    }

    public void addThreeB(View view) {
        scoreB+=3;
        displayB(scoreB);

    }

    private void displayB(int scoreB) {
        TextView textView = (TextView) findViewById(R.id.textView4);
        textView.setText(""+scoreB);
    }

    public void addTwoB(View view) {
        scoreB+=2;
        displayB(scoreB);
    }

    public void freeB(View view) {
        scoreB+=1;
        displayB(scoreB);
    }

    public void Reset(View view) {
        scoreB=0;
        scoreA=0;
        displayA(scoreA);
        displayB(scoreB);
    }

    public void share(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822"); // MIME type for email messages
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"sahil.agrawal@mitaoe.ac.in"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding Basketball Scores");
        intent.putExtra(Intent.EXTRA_TEXT, "Team A Score ="+scoreA+"\nTeam B Score ="+scoreB);
       // intent.setPackage("com.google.android.gm"); for direct gmailing the scores
        try {
            startActivity(Intent.createChooser(intent, "Send Email"));// for choosing between apps
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
        }


    }
}