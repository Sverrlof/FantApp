package no.ntnu.sverrlof.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.Rest.ApiClient;
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
    }
        /*

        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserPrefs userPrefs = new UserPrefs(view.getContext());
                if (userPrefs.getToken().isEmpty()) {
                    Toast.makeText(ItemActivity.this, "You need to be logged in to buy items", Toast.LENGTH_SHORT).show();
                }
                else {
                    buyItem();
                }
            }
        });


    }

    public void buyItem() {

        final UserPrefs userPrefs = new UserPrefs(this);

        String token = "Bearer " + userPrefs.getToken();
        Long itemid = null;

        Call<ResponseBody> call = ApiClient
                .getSINGLETON()
                .getApi()
                .purchaseItem(token, itemid);


    }*/
    }
