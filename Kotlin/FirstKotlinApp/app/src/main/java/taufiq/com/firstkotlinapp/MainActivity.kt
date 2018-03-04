package taufiq.com.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_NAME = "name"
    }


    lateinit var editTextName : EditText
    lateinit var buttonClickMe: Button
    lateinit var buttonIntroduce: Button
    lateinit var buttonResult: Button
    lateinit var textViewMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName =findViewById(R.id.et_name)
        buttonClickMe=findViewById(R.id.bt_click)
        textViewMessage=findViewById(R.id.message)
        buttonIntroduce=findViewById(R.id.bt_introduce)
        buttonResult=findViewById(R.id.bt_result)

        val myClickListener= object : View.OnClickListener{
            override fun onClick(view: View?) {

                when(view?.id){
                    R.id.bt_introduce ->{
                        var name =editTextName.text
                        textViewMessage.text = "Hello $name , I am Your Friend"
                    }
                    R.id.bt_click ->{
                        var name =editTextName.text
                        textViewMessage.text = "Hello $name "
                    }
                    R.id.bt_result ->{
                        val intent: Intent=Intent(applicationContext,ResultActivity::class.java)
                        val name = editTextName.text.toString()

                        intent.putExtra(KEY_NAME,name)

                        startActivity(intent)
                    }
                }
            }

        }

        buttonClickMe.setOnClickListener(myClickListener)
        buttonIntroduce.setOnClickListener(myClickListener)
        buttonResult.setOnClickListener(myClickListener)
    }

}
