package ataufiq.com.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreATxt, scoreBTxt;
    int scoreTeamA, scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreATxt = findViewById(R.id.score_a_txt);
        scoreBTxt = findViewById(R.id.score_b_txt);
    }

    public void displayScoreA(int score) {
        scoreATxt.setText("" + score);
    }

    public void plus3TeamA(View v) {
        scoreTeamA += 3;
        displayScoreA(scoreTeamA);
    }

    public void plus2TeamA(View v) {
        scoreTeamA += 2;
        displayScoreA(scoreTeamA);
    }

    public void plus1TeamA(View v) {
        scoreTeamA++;
        displayScoreA(scoreTeamA);
    }

    //------------------------------------------

    public void displayScoreB(int score) {
        scoreBTxt.setText("" + score);
    }

    public void plus3TeamB(View v) {
        scoreTeamB += 3;
        displayScoreB(scoreTeamB);
    }

    public void plus2TeamB(View v) {
        scoreTeamB += 2;
        displayScoreB(scoreTeamB);
    }

    public void plus1TeamB(View v) {
        scoreTeamB++;
        displayScoreB(scoreTeamB);
    }

    //----------------------------
    public void reset(View v) {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayScoreB(scoreTeamB);
        displayScoreA(scoreTeamA);
    }
}
