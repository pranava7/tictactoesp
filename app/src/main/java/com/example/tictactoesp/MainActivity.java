package com.example.tictactoesp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int rounds;
    public static  String player1name;
    public static  String player2name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b = (Button) findViewById(R.id.button) ;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText rounde = (EditText) findViewById(R.id.editText);
                String srounds = rounde.getText().toString() ;
                if(srounds.equals("") || srounds.equals("0")) {
                    Toast.makeText(MainActivity.this, "No. of rounds should be greater than 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                rounds = Integer.parseInt(srounds , 10) ;


                if(rounds == 0) {
                    Toast.makeText(MainActivity.this, "No. of rounds should be greater than 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                final EditText player1 = (EditText) findViewById(R.id.player1_name);
                player1name = player1.getText().toString();

                final EditText player2 = (EditText) findViewById(R.id.player2_name);
                player2name = player2.getText().toString();

                if(player1name.equals("")) {
                    Toast.makeText(MainActivity.this, "Enter a valid name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(player2name.equals("")) {
                    Toast.makeText(MainActivity.this, "Enter a valid name", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent colorsIntent = new Intent(MainActivity.this, players2activity.class);

                // Start the new activity
                startActivity(colorsIntent);
            }
        });
    }
}
