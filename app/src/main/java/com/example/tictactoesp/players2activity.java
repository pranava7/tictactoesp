package com.example.tictactoesp;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class players2activity extends AppCompatActivity {

    public static TextView roundswonbyxtv;
    public static TextView roundswonbyotv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.players2activity_layout);
        TextView t1= (TextView) findViewById(R.id.player1name);
        TextView t2= (TextView) findViewById(R.id.player2name);
        t1.setText(MainActivity.player1name);
        t2.setText(MainActivity.player2name);
        roundswonbyxtv=(TextView) findViewById(R.id.wonbyx);
        roundswonbyotv=(TextView) findViewById(R.id.wonbyo);

    }
}
