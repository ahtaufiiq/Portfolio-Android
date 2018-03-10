package taufiq.com.trynetworking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView title,description,nomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //find Intent from Main Activity
        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("title");
        String mDescription = intent.getStringExtra("description");
        String mNomor = intent.getStringExtra("foto");

        //find TextView then set title to view
        title = findViewById(R.id.id);
        title.setText(mTitle);

        //find TextView then set description to view
        description = findViewById(R.id.nama);
        description.setText(mDescription);

        nomor = findViewById(R.id.nomor);
        nomor.setText(mNomor);
    }
}
