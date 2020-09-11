package com.inkarestaurent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity  {

    private BottomNavigationView bottomNavigationView;
    private  Button one_add,one_sub;private TextView one_txt;
    private  Button two_add,two_sub;private TextView two_txt;
    private  Button three_add,three_sub;private TextView three_txt;

    //add buttons
    private Button one_add_btn,two_add_btn,three_add_btn;
    //elegant buttons
   private CardView one_btn,two_btn,three_btn;

    //Cart Total items
    TextView cartToalItems;

    //TotalCostCard

    private Button main_one;
    private int totalItems;

    //count for showMore

    private int countShow=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String TAG=getClass().getName().toString();
        bottomNavigationView=findViewById(R.id.cartNavigationBar);

        one_add=findViewById(R.id.elegant_btn_add);one_sub=findViewById(R.id.elegant_btn_sub); one_txt=findViewById(R.id.elegant_btn_txt);
        two_add=findViewById(R.id.elegant2_btn_add);two_sub=findViewById(R.id.elegant2_btn_sub);two_txt=findViewById(R.id.elegant2_btn_txt);
        three_add=findViewById(R.id.elegant3_btn_add);three_sub=findViewById(R.id.elegant3_btn_sub);three_txt=findViewById(R.id.elegant3_btn_txt);

        //add buttons
        one_add_btn=findViewById(R.id.one_add_btn);
        two_add_btn=findViewById(R.id.two_add_btn);
        three_add_btn=findViewById(R.id.three_add_btn);

        //elegant btns
       one_btn=findViewById(R.id.one_btn);
        two_btn=findViewById(R.id.two_btn);
        three_btn=findViewById(R.id.three_btn);

        //cart Total items
        cartToalItems=findViewById(R.id.cart_total_items);
        String line[]=cartToalItems.getText().toString().trim().split("\\s+");
         totalItems = Integer.parseInt(line[1]);

         //count for show more
        countShow=0;


        // when count is 0 and three buttons ADD
         one_add_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 totalItems++;
                 countShow++;
                 cartToalItems.setText(" ( "+totalItems+" ITEMS)");
                 one_add_btn.setVisibility(View.INVISIBLE);
                 one_txt.setText(String.valueOf(1));
                 one_btn.setVisibility(View.VISIBLE);

             }
         });

         two_add_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 totalItems++;
                 countShow++;
                 cartToalItems.setText(" ( "+totalItems+" ITEMS)");
                 two_add_btn.setVisibility(View.INVISIBLE);
                 two_txt.setText(String.valueOf(1));
                 two_btn.setVisibility(View.VISIBLE);
             }
         });

         three_add_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 totalItems++;
                 countShow++;
                 cartToalItems.setText(" ( "+totalItems+" ITEMS)");
                 three_add_btn.setVisibility(View.INVISIBLE);
                 three_txt.setText(String.valueOf(1));
                 three_btn.setVisibility(View.VISIBLE);
             }
         });


        one_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(one_txt.getText().toString().trim());
                if(count<20) {
                    count++;
                    one_txt.setText(String.valueOf(count));
                    totalItems++;
                    cartToalItems.setText(" ( "+totalItems+" ITEMS)");
                }
            }
        });
        one_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(one_txt.getText().toString().trim());

                if(count>0)
                {
                    count--;
                    totalItems--;
                    one_txt.setText(String.valueOf(count));
                    cartToalItems.setText(" ( "+totalItems+" ITEMS)");

                    if(count==0)
                    {   countShow--;

                        one_btn.setVisibility(View.INVISIBLE);
                        one_add_btn.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        two_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(two_txt.getText().toString().trim());
                if(count<20) {
                    count++;
                    totalItems++;
                    two_txt.setText(String.valueOf(count));
                    cartToalItems.setText(" ( " + totalItems + " ITEMS)");
                }
            }
        });

        two_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(two_txt.getText().toString().trim());

                if(count>0)
                {
                    count--;totalItems--;
                    two_txt.setText(String.valueOf(count));
                    cartToalItems.setText(" ( "+totalItems+" ITEMS)");

                    if(count==0)
                    {   countShow--;

                        two_btn.setVisibility(View.INVISIBLE);
                        two_add_btn.setVisibility(View.VISIBLE);

                    }
                }
            }
        });

        three_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(three_txt.getText().toString().trim());
                if(count<20) {
                    count++;
                    totalItems++;
                    three_txt.setText(String.valueOf(count));
                    cartToalItems.setText(" ( " + totalItems + " ITEMS)");
                }
            }
        });


        three_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count=Integer.parseInt(three_txt.getText().toString().trim());

                if(count>0)
                {
                    count--;totalItems--;
                    three_txt.setText(String.valueOf(count));
                    cartToalItems.setText(" ( "+totalItems+" ITEMS)");

                    if(count==0)
                    {   countShow--;
                        three_btn.setVisibility(View.INVISIBLE);
                        three_add_btn.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        bottomNavigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"RV: navbar clicked");
                bottomNavigationClickMethod();

            }
        });






    }

    private void bottomNavigationClickMethod(){
        String TAG=getClass().getName().toString();
        String all_item_val=countItemString();
        String countItem=countItem();


        Intent intent=new Intent(getApplicationContext(),placeOrder.class);
        intent.putExtra("totalCount",String.valueOf(totalItems));
        intent.putExtra("countItem",String.valueOf(countItem));
        intent.putExtra("itemsString",all_item_val);
        Log.i(TAG,"Sttring:"+all_item_val);


        startActivity(intent);
    }

    private String countItem()
    {    int count=0;

        int one=Integer.parseInt(one_txt.getText().toString());
        int two=Integer.parseInt(two_txt.getText().toString());
        int three=Integer.parseInt(three_txt.getText().toString());

        if(one>0)
            count++;
        if(two>0)
            count++;
        if(three>0)
            count++;

        return String.valueOf(count);
    }
    private String countItemString(){
        String s="";
        String val="";
        int one=Integer.parseInt(one_txt.getText().toString());
        int two=Integer.parseInt(two_txt.getText().toString());
        int three=Integer.parseInt(three_txt.getText().toString());

        if(one>0) {
            s = "1" +" "+String.valueOf(one)+" ";

        }
        if(two>0) {
            s += "2" +" "+String.valueOf(two)+" ";

        }
        if(three>0) {
            s += "3" +" "+String.valueOf(three)+" ";

        }
        return s;



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        String TAG = getClass().toString().trim();
        Log.i(TAG, "Here i came::");
        if (requestCode == 1)
            if (resultCode == RESULT_OK) {
                String Count = data.getStringExtra("cartAllItems");


                int arr[] = new int[3];
                String str[] = Count.split("\\s+");
                for (int i = 0; i < 3; i++)
                    arr[i] = Integer.parseInt(str[i]);

                if (arr[0] == 0) {
                    one_txt.setText("0");
                    one_btn.setVisibility(View.INVISIBLE);
                    one_add_btn.setVisibility(View.VISIBLE);
                } else {
                    one_txt.setText(String.valueOf(arr[0]));
                }

                if (arr[1] == 0) {
                    two_txt.setText("0");
                    two_btn.setVisibility(View.INVISIBLE);
                    two_add_btn.setVisibility(View.VISIBLE);
                } else {
                    two_txt.setText(String.valueOf(arr[1]));
                }

                if (arr[2] == 0) {
                    three_txt.setText("0");
                    three_btn.setVisibility(View.INVISIBLE);
                    three_add_btn.setVisibility(View.VISIBLE);
                } else {
                    three_txt.setText(String.valueOf(arr[2]));
                }


            }

    }
}