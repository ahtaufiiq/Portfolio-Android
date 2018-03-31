package com.example.ataufiq.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ataufiq.firebase.model.Makanan;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String MAKANAN_NAME = "makananName";
    public static final String MAKANAN_ID = "makananId";
    public static final String table1 = "Makanan";
    public static final String table2 = "Review";

    EditText et_food_name;
    Spinner spinner_type_food;
    Button btn_add_food;
    ListView listViewFood;

    //a list to store all the artist from firebase database
    List<Makanan> makanans;

    //our database reference object
    DatabaseReference databaseFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getting the reference of artists node
        databaseFood = FirebaseDatabase.getInstance().getReference(table1);

        //getting views
        et_food_name = (EditText) findViewById(R.id.editTextName);
        spinner_type_food = (Spinner) findViewById(R.id.spinner_tipe_makanan);
        listViewFood = (ListView) findViewById(R.id.listViewArtists);

        btn_add_food = (Button) findViewById(R.id.buttonAddArtist);

        //list to store artists
        makanans = new ArrayList<>();


        //adding an onclicklistener to button
        btn_add_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                addArtist();
            }
        });

    }

    private void addArtist() {
        //getting the values to save
        String name = et_food_name.getText().toString().trim();
        String jenis = spinner_type_food.getSelectedItem().toString();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseFood.push().getKey();

            //creating an Artist Object
            Makanan makanan = new Makanan(id, name, jenis);

            //Saving the Artist
            databaseFood.child(id).setValue(makanan);

            //setting edittext to blank again
            et_food_name.setText("");

            //displaying a success toast
            Toast.makeText(this, "Food added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous artist list
                makanans.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting artist
                    Makanan makanan = postSnapshot.getValue(Makanan.class);
                    //adding artist to the list
                    makanans.add(makanan);
                }

                //creating adapter
                MakananList makananList = new MakananList(MainActivity.this,makanans);
                //attaching adapter to the listview
                listViewFood.setAdapter(makananList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
