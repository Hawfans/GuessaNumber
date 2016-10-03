package com.algonquincollege.medh0003.guessanumber;


import android.app.DialogFragment;
import android.icu.text.AlphabeticIndex;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

import static com.algonquincollege.medh0003.guessanumber.R.id.guess;

public class MainActivity extends AppCompatActivity {
    private static final String ABOUT_DIALOG_TAG;
    private static final String LOG_TAG;
    public int count;
    protected int number;

    static {
        ABOUT_DIALOG_TAG = "About Dialog";
        LOG_TAG = "GUESS A NUMBER";
    }

    EditText guessText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;

        Random rn = new Random();
        number = rn.nextInt(1000) + 1;

        guessText = (EditText) findViewById( R.id.guess );

        Button guessButton = (Button) findViewById( R.id.guessButton );

        guessButton.setOnClickListener(new OnClickListener(){

                @Override
                public void onClick(View v) {

                    String guess = guessText.getText().toString();

                    Log.i(LOG_TAG, String.valueOf(number));

                    int numberInput = Integer.parseInt(guess);


                    if (numberInput == number) {

                        if (count < 5 ) {
                            Toast.makeText(getApplicationContext(), "Excellent Win!",Toast.LENGTH_SHORT).show();
                        } else if (count >= 6 && count <= 9) {
                            Toast.makeText(getApplicationContext(), "Superior Win!",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }

                    if (numberInput > number) {
                        Toast.makeText(getApplicationContext(), "Too High!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (numberInput < number) {
                        Toast.makeText(getApplicationContext(), "Too Low!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (count >= 10) {
                        Toast.makeText(getApplicationContext(),"You are all out of Guesses", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    count++;

                }

            });

        Button resetButton = (Button) findViewById( R.id.resetButton );

            resetButton.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    count = 0;

                    Random rn = new Random();
                    number = rn.nextInt(1000) + 1;

                    guessText.setText("");

                    Toast.makeText(getApplicationContext(), "Try Again?", Toast.LENGTH_LONG).show();

                }
            });

        resetButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override

            public boolean onLongClick(View v) {

                Toast.makeText(getApplicationContext(), "The random number was " + number, Toast.LENGTH_LONG).show();

                return true;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_about) {
            DialogFragment newFragment = new AboutDialogFragment();
            newFragment.show(getFragmentManager(), ABOUT_DIALOG_TAG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
