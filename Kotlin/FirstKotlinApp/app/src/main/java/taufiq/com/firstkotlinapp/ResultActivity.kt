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

        val hero=intent.getSerializableExtra(MainActivity.KEY_NAME) as Hero

        textViewName.text="Name Is: "+ hero.name +" And Real Name is: "+hero.realName

    }
}
