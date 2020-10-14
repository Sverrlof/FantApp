package no.ntnu.sverrlof.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessController;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.Rest.ApiClient;
import no.ntnu.sverrlof.adapter.ItemListAdapter;
import no.ntnu.sverrlof.model.Item;
import no.ntnu.sverrlof.model.User;
import no.ntnu.sverrlof.preference.UserPrefs;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity {

    private TextView textViewItemName, textViewDesc, textViewPrice;
    private Button buyBtn;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        textViewItemName = findViewById(R.id.textItemName);
        textViewDesc = findViewById(R.id.textItemDesc);
        textViewPrice = findViewById(R.id.textItemPrice);
        buyBtn = findViewById(R.id.buyItemButton);
        toolbar = findViewById(R.id.mytoolbar);


        //Setting up the toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textViewItemName.setText(getIntent().getStringExtra("item"));
        textViewDesc.setText(getIntent().getStringExtra("description"));
        textViewPrice.setText(getIntent().getStringExtra("price") + "kr");

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buyItem();
            }
        });
    }


    public void buyItem() {

        final UserPrefs userPrefs = new UserPrefs(this);

       // ItemListAdapter itemListAdapter = new ItemListAdapter(getApplicationContext());
        Bundle bundleExtra = getIntent().getExtras();
        String token = "Bearer " + userPrefs.getToken();

        if(bundleExtra != null) {
            Long itemid = bundleExtra.getLong("itemid");

            Call<ResponseBody> call = ApiClient
                    .getSINGLETON()
                    .getApi()
                    .purchaseItem(token, itemid);

            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        Toast.makeText(ItemActivity.this, "Item bought", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                }
            });

        } else {

        }


   //     Long itemid = getIntent().getLongExtra("iid", 3);


    }
    }
