package com.teamtreehouse.funfacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOUR = "KEY_COLOUR";
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    // Declare our View variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;
    private String mFact;
    private int mColor;


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        factTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOUR);
        relativeLayout.setBackgroundColor(mColor);
        showFactButton.setTextColor(mColor);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        
        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOUR, mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout file to the corresponding variables
        factTextView = findViewById(R.id.factTextView);
        showFactButton = findViewById(R.id.showFactButton);
        relativeLayout = findViewById(R.id.relativeLayout);

        displayNewFact();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Update the screen with our new fact
                displayNewFact();
            }
        };
        showFactButton.setOnClickListener(listener);

        //Toast.makeText(this, "Yay! Our Activity was created", Toast.LENGTH_LONG).show();
        //Log.d(TAG, "We're logging from the oncreate method!");
    }

    private void displayNewFact() {
        mColor = colorWheel.getColor();
        relativeLayout.setBackgroundColor(mColor);
        showFactButton.setTextColor(mColor);
        mFact = factBook.getFact();
        factTextView.setText(mFact);
    }
}
