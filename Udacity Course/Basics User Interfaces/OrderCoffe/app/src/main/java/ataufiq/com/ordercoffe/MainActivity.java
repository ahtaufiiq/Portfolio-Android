package ataufiq.com.ordercoffe;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView quantityTxt;
    Button orderBtn;
    CheckBox wippedCream,chocolate;
    EditText name;
    int quantity=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quantityTxt = findViewById(R.id.quantity_txt);

        orderBtn    = findViewById(R.id.order_btn);

        wippedCream =findViewById(R.id.wipped_checkbox);
        chocolate   = findViewById(R.id.chocolate_checkbox);

        name    =findViewById(R.id.name_edit_text);

    }

    public void display(int number){
        //Set text only get string so we must change int to string
        quantityTxt.setText(String.valueOf(number));
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
        String nama =name.getText().toString();

        boolean hasWippedCream  = wippedCream.isChecked();
        boolean hasChocolate    = chocolate.isChecked();

        int price= calculatePrice(hasWippedCream,hasChocolate);

        String message=createOrderSummary(nama,price,hasWippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,"Order Coffe");
        intent.putExtra(intent.EXTRA_TEXT,message);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public String createOrderSummary(String nama,int price,boolean addWippedCream,boolean addChocolate){
        String message="Name: "+nama+
                        "\nQuantity: "+quantity+
                        "\nWhipped Cream: "+ addWippedCream+
                        "\nChocolate: "+ addChocolate+
                        "\nTotal: $"+price+
                        "\nThank You";
        return message;
    }

    public int calculatePrice(boolean addWipppedCream,boolean addChocolate){
        int price =0;

        price=quantity*5;

        if (addWipppedCream){
            price+=1;
        }
        if (addChocolate){
            price+=2;
        }
        return price;
    }
}
