package taufiq.com.introfirebase

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firebaseDatabase = FirebaseDatabase.getInstance()
        //Gunakan Push Sehingga datanya tidak menimpa yang sebelumnya
        var databaseRef =firebaseDatabase.getReference("messages").push()

        var employee= Employee("Taufiq","Android Developer",
                "Bandung",20)

        databaseRef.setValue(employee)

        //Read From our DB
        databaseRef.addValueEventListener(object : ValueEventListener {


            override fun onDataChange(dataSnapshot: DataSnapshot?) {
                var value =dataSnapshot!!.value as HashMap<String,Any>

                Log.d("Value",value.get("name").toString())
            }
            override fun onCancelled(error: DatabaseError?) {

                Log.d("error",error!!.message)

            }
        })
    }

    data class Employee(var name:String,var position: String,
                        var homeAddress:String,var age:Int){

    }

}
