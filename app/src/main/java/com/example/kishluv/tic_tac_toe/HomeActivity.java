package com.example.kishluv.tic_tac_toe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
    public void submit(View v)
    {
        switch (v.getId())
        {
            case R.id.singleplayer:
                Toast.makeText(this,"One player is selected",Toast.LENGTH_SHORT).show();
                Intent i= new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.multiplayer:
                Toast.makeText(this,"Two players are selected",Toast.LENGTH_SHORT).show();
                Intent in= new Intent(this,MainActivity.class);
                startActivity(in);
                break;
        }

    }
}
