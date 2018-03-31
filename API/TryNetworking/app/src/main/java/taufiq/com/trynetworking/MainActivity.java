package taufiq.com.trynetworking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    EditText mNama, mNomor;
    Button buttonPost;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private LinkedList<Kontak> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        mNama = findViewById(R.id.et_nama);
        mNomor = findViewById(R.id.et_nomor);

        buttonPost = findViewById(R.id.bt_post);

        //Create variabel LinkedList for save data
        listItems = new LinkedList<>();

        getKontak();
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 1));
        //add data to adapter and throw context
        adapter = new KontakAdapter(listItems, this);
        //set adapter
        recyclerView.setAdapter(adapter);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                postKontak(mNama.getText().toString(), mNomor.getText().toString());
                getKontak();

            }
        });


    }

    public void getKontak() {
        AndroidNetworking.get("http://10.0.3.2/api_namasa/index.php/product")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {

                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);
                                listItems.add(new Kontak(obj.getString("description"), obj.getString("name"), obj.getString("name")));
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d("nama", String.valueOf(error));
                    }
                });

    }

    public void postKontak(String nama, String nomor) {
        AndroidNetworking.post("http://10.0.3.2/rest_ci/index.php/kontak")
                .addBodyParameter("nama", nama)
                .addBodyParameter("nomor", nomor)
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("nama", String.valueOf(error));
                    }
                });
    }

    public void deleteKontak(String id) {
        AndroidNetworking.delete("http://10.0.3.2/rest_ci/index.php/kontak")
                .addBodyParameter("id", "11")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("nama", String.valueOf(error));
                    }
                });
    }

    public void updateKontak(String id, String nama, String nomor) {
        AndroidNetworking.put("http://10.0.3.2/rest_ci/index.php/kontak")
                .addBodyParameter("id", "3")
                .addBodyParameter("nama", "Andi")
                .addBodyParameter("nomor", "11")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // do anything with response
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Log.d("nama", String.valueOf(error));
                    }
                });
    }
}
