package com.inkarestaurent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class placeOrder extends AppCompatActivity {


    //Intent to get values for last Intent
    private Intent intent;
    private TextView totalCost;
    private int totalItems;

    //TextView all quantity
    private TextView first_item_count,second_item_count,third_item_count;

    //Buttons for quantity
    private Button first_item_add,first_item_sub,second_item_add,second_item_sub,third_item_add,third_item_sub;

    //TextView showmore
    TextView showMore;
    //Recycler cart Items
    RecyclerView recyclerView;

    //Relative Layout
    private RelativeLayout first_item_cart,second_item_cart,third_item_cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        showMore=findViewById(R.id.cart_show_more);
        first_item_cart=findViewById(R.id.first_item_cart);
        second_item_cart=findViewById(R.id.second_item_cart);
        third_item_cart=findViewById(R.id.third_item_cart);

        //TextView Quantity
        first_item_count=findViewById(R.id.first_item_count);
        second_item_count=findViewById(R.id.second_item_count);
        third_item_count=findViewById(R.id.third_item_count);


        //count quantity buttons

        first_item_add=findViewById(R.id.first_item_add);
        first_item_sub=findViewById(R.id.first_item_sub);
        second_item_add=findViewById(R.id.second_item_add);
        second_item_sub=findViewById(R.id.second_item_sub);
        third_item_add=findViewById(R.id.third_item_add);
        third_item_sub=findViewById(R.id.third_item_sub);



        showMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                third_item_cart.setVisibility(View.VISIBLE);
                showMore.setVisibility(View.INVISIBLE);
            }
        });
        first_item_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(first_item_count.getText().toString());

                if(count<20)
                {
                    count++;
                    totalItems++;
                    totalCost.setText("€"+String.valueOf(totalItems*7)+".00");
                    first_item_count.setText(String.valueOf(count));
                }
            }
        });
        first_item_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(first_item_count.getText().toString());
                totalItems--;
                totalCost.setText("€"+String.valueOf(totalItems*7)+".00");
                if(count==1)
                {
                    first_item_cart.setVisibility(View.GONE);

                }
                count--;
                first_item_count.setText(String.valueOf(count));
            }
        });

        //for second
        second_item_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(second_item_count.getText().toString());

                if(count<20)
                {
                    count++;
                    totalItems++;
                    totalCost.setText("€"+String.valueOf(totalItems*7)+".00");

                    second_item_count.setText(String.valueOf(count));
                }
            }
        });
        second_item_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(second_item_count.getText().toString());

                totalItems--;
                totalCost.setText("€"+String.valueOf(totalItems*7)+".00");
                if(count==1)
                {
                    second_item_cart.setVisibility(View.GONE);

                }
                count--;
                second_item_count.setText(String.valueOf(count));
            }
        });
        // for third

        third_item_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(third_item_count.getText().toString());

                if(count<20)
                {
                    count++;
                    totalItems++;
                    totalCost.setText("€"+String.valueOf(totalItems*7)+".00");
                    third_item_count.setText(String.valueOf(count));
                }
            }
        });
        third_item_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(third_item_count.getText().toString());
                totalItems--;
                totalCost.setText("€"+String.valueOf(totalItems*7)+".00"); if(count==1)
                {
                    third_item_cart.setVisibility(View.GONE);

                }
                count--;
                third_item_count.setText(String.valueOf(count));
            }
        });







    }

    @Override
    protected void onStart() {
        super.onStart();
        String TAG=getClass().getName().toString();
        //intent
        intent=getIntent();
        totalCost=findViewById(R.id.total_cost_txt);
        int totalCount=Integer.parseInt(intent.getStringExtra("totalCount"));
        int totalItem=Integer.parseInt(intent.getStringExtra("countItem"));
        totalItems=totalCount;
        String itemString=intent.getStringExtra("itemsString");


        totalCost.setText("€"+String.valueOf(totalCount*7)+".00");

        if(totalItem>2)
        {
            showMore.setVisibility(View.VISIBLE);
        }

        String str[]=itemString.trim().split("\\s+");
        Log.i(TAG,"given is::"+itemString);
        int itemArray[]=new int[str.length];

        for(int i=0;i<totalItem*2;i++) {
            itemArray[i] = Integer.parseInt(str[i]);
        }
        for(int i=0;i<totalItem*2;i+=2)
        {
            if(itemArray[i]==1)
            {
                first_item_cart.setVisibility(View.VISIBLE);
                Log.i(TAG,"set::1:"+String.valueOf(itemArray[i+1]));
                first_item_count.setText(String.valueOf(itemArray[i+1]));

            }
            if(itemArray[i]==2)
            {
                second_item_cart.setVisibility(View.VISIBLE);
                Log.i(TAG,"set::2:"+String.valueOf(itemArray[i+1]));
                second_item_count.setText(String.valueOf(itemArray[i+1]));
            }

            if(itemArray[i]==3)
            {     Log.i(TAG,"set::3:"+String.valueOf(itemArray[i+1]));
                third_item_count.setText(String.valueOf(itemArray[i+1]));
            }

        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intentBack=new Intent(getApplicationContext(),MainActivity.class);
        String items=first_item_count.getText().toString()+" "+second_item_count.getText().toString()+" "+third_item_count.getText().toString();

        intentBack.putExtra("cartAllItems",items);
        setResult(RESULT_OK,intentBack);
       finish();

    }
}