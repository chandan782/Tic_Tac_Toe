package com.example.kishluv.tic_tac_toe;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button a1,a2,a3,b1,b2,b3,c1,c2,c3,brestart;
    Button[] bArray;
   boolean turn=false;
    int turn_count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        bArray=new Button[]{a1,a2,a3,b1,b2,b3,c1,c2,c3};
        for(Button b:bArray)
        {
            b.setOnClickListener(this);
        }
        brestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn=true;
                turn_count=0;
                enabledisableAllButtons(true);
            }
        });
    }
    private void initViews()
    {
        a1=(Button)findViewById(R.id.btn1);
        a2=(Button)findViewById(R.id.btn2);
        a3=(Button)findViewById(R.id.btn3);
        b1=(Button)findViewById(R.id.btn4);
        b2=(Button)findViewById(R.id.btn5);
        b3=(Button)findViewById(R.id.btn6);
        c1=(Button)findViewById(R.id.btn7);
        c2=(Button)findViewById(R.id.btn8);
        c3=(Button)findViewById(R.id.btn9);
        brestart=(Button)findViewById(R.id.restart);
    }

    @Override
    public void onClick(View v)
    {
        Button b=(Button)v;
        buttonClicked(b);
    }
    public void buttonClicked(Button b)
    {
        if(turn) {
            b.setText("X");
        }
        else
        {
            b.setText("O");
        }
        b.setBackgroundColor(Color.LTGRAY);
        b.setClickable(false);
        turn=!turn;
        checkforWinner();
    }
    private void checkforWinner()
    {
        boolean there_is_a_winner=false;
        //horizontal check
        if(a1.getText()==a2.getText() && a2.getText()==a2.getText() && !a1.isClickable())
        {
           there_is_a_winner=true;
        }
        else if(b1.getText()==b2.getText() && b2.getText()==b3.getText() && !b1.isClickable())
        {
            there_is_a_winner=true;
        } if(c1.getText()==c2.getText() && c2.getText()==c3.getText() && !c1.isClickable())
        {
            there_is_a_winner=true;
        }
        //diagonal check
        else if(a1.getText()==b2.getText() && b2.getText()==c3.getText() && !a1.isClickable())
        {
            there_is_a_winner=true;
        }
        else if(a3.getText()==b2.getText() && b2.getText()==c1.getText() && !b2.isClickable())
        {
            there_is_a_winner=true;
        }
        //vertical check
        else if(a1.getText()==b1.getText() && b1.getText()==c1.getText() && !a1.isClickable())
        {
            there_is_a_winner=true;
        }
        else if(a2.getText()==b2.getText() && b2.getText()==c2.getText() && !b2.isClickable())
        {
            there_is_a_winner=true;
        }
        else if(a3.getText()==b3.getText() && b3.getText()==c3.getText() && !c3.isClickable())
        {
            there_is_a_winner=true;
        }
        if(there_is_a_winner)
        {
            if(!turn)
            {
                toast("X wins");
            }
            else
            {
                toast("O wins");
            }
            enabledisableAllButtons(false);
        }
        else if(turn_count==9)
        {
            toast("Draw");
        }
    }

    private void enabledisableAllButtons(boolean enable) {
        for (Button b:bArray)
        {
            b.setClickable(enable);
            if(enable)
            {
                b.setBackgroundColor(Color.parseColor("#16a085"));
                b.setText("");
            }
            else {
                b.setBackgroundColor(Color.LTGRAY);
            }
        }
    }

    private void toast(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
