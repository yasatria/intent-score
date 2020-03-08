package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView tvwinner;
    private String winner;
    public static final String EXTRA_RESULT = "EXTRA_RESULT";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //bind view
        Intent intent = getIntent();
        winner = intent.getStringExtra(EXTRA_RESULT);

        tvwinner = findViewById(R.id.textView3);
        tvwinner.setText(winner);
    }
}
