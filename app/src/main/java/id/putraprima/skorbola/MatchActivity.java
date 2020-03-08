package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.putraprima.skorbola.Model.Model;

public class MatchActivity extends AppCompatActivity {

    private TextView homeName;
    private TextView awayName;
    private TextView homeScore;
    private TextView awayScore;
    private ImageView homeLogo;
    private  ImageView awayLogo;
    private int home_score =0;
    private int away_score =0;
    private String winner;
    private Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //bind view
        homeName = findViewById(R.id.txt_home);
        awayName = findViewById(R.id.txt_away);
        homeScore = findViewById(R.id.score_home);
        awayScore = findViewById(R.id.score_away);
        awayLogo = findViewById(R.id.away_logo);
        homeLogo = findViewById(R.id.home_logo);

        Bundle extras = getIntent().getExtras();

        if(extras != null){
            model = extras.getParcelable(MainActivity.USER_KEY);
            homeName.setText(model.getHomeName());
            awayName.setText(model.getAwayName());
            homeScore.setText(String.valueOf(model.getHomeScore()));
            awayScore.setText(String.valueOf(model.getAwayScore()));
            Bitmap bmp = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("homeLogo"), 0, getIntent().getByteArrayExtra("homeLogo").length);
            homeLogo.setImageBitmap(bmp);
            Bitmap bmpAway = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("awayLogo"), 0, getIntent().getByteArrayExtra("awayLogo").length);
            awayLogo.setImageBitmap(bmpAway);
        }
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }

    public void handleAddHomeScore(View view) {
        //set nilai homescore
        this.home_score++;
        //set di view
        homeScore.setText(String.valueOf(home_score));
    }

    public void handleAddAwayScore(View view) {
        //set nilai homescore
        this.away_score++;
        //set di view
        awayScore.setText(String.valueOf(away_score));
    }

    public void handleCekHasil(View view) {
        Intent intent = new Intent(this, ResultActivity.class );

        intent.putExtra(ResultActivity.EXTRA_RESULT,winner);

        if(home_score>away_score){
            winner = "The winner is " + homeName.getText().toString();
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }
        else if(home_score<away_score){
            winner = "The winner is " + awayName.getText().toString();
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }
        else if(home_score==away_score){
            winner = "The result is Draw ";
            intent.putExtra(ResultActivity.EXTRA_RESULT,winner);
        }

        startActivity(intent);
    }
}
