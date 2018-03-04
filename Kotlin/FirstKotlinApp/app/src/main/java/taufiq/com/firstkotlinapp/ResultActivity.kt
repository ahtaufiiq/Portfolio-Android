package taufiq.com.firstkotlinapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    lateinit var textViewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        textViewName =findViewById(R.id.tv_name)

        val name= intent.getStringExtra(MainActivity.KEY_NAME)

        textViewName.text="Hey $name"

    }
}
