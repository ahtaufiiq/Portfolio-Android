package ataufiq.com.ordercoffe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView quantityTxt,priceTxt;
    Button orderBtn;
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTxt = findViewById(R.id.quantity_txt);
        priceTxt    = findViewById(R.id.price_txt);
        orderBtn    = findViewById(R.id.order_btn);



    }

    public void display(int number){
        //Set text only get string so we must change int to string
        quantityTxt.setText(String.valueOf(number));
    }

    public void displayPrice(int number){
        priceTxt.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displatMessage(String message){
        priceTxt.setText(message);
    }

    public void increment(View v){
        quantity++;
        display(quantity);
    }

    public void decrement(View v){
        quantity--;
        display(quantity);
    }

    public void orderButton(View v){
        String priceMessage="Total: $"+ quantity*5+"\nThank You";
        displatMessage(priceMessage);
    }
}
