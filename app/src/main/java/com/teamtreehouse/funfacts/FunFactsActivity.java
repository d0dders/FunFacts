package com.teamtreehouse.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private FactBook factBook = new FactBook();
    private ColorWheel colorWheel = new ColorWheel();
    // Declare our View variables
    private TextView factTextView;
    private Button showFactButton;
    private RelativeLayout relativeLayout;



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
        int color = colorWheel.getColor();
        relativeLayout.setBackgroundColor(color);
        factTextView.setText(factBook.getFact());
        showFactButton.setTextColor(color);
    }
}
