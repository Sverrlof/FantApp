package no.ntnu.sverrlof.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.Rest.ApiClient;
import no.ntnu.sverrlof.model.Item;
import no.ntnu.sverrlof.model.User;
import no.ntnu.sverrlof.preference.UserPrefs;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddItemFragment extends Fragment {
    private EditText editTextTitle, editTextDesc, editTextPrice;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_item, container, false);

        editTextTitle = view.findViewById(R.id.editTextTitle);
        editTextDesc = view.findViewById(R.id.editTextDesc);
        editTextPrice = view.findViewById(R.id.editTextPrice);

        Button addItemBtn = (Button) view.findViewById(R.id.addItemButton);

        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int price = Integer.parseInt(editTextPrice.getText().toString());
                if (editTextTitle.getText().toString().length() == 0 || price < 0) {
                    Toast.makeText(getContext(), "Fill in the empty fields", Toast.LENGTH_SHORT).show();
                } else {
                    addItem();
                }

            }

        });


        return view;
    }


    public void addItem() {
        final String itemTitle = editTextTitle.getText().toString();
        final String itemDesc = editTextDesc.getText().toString();
        final int itemPrice = Integer.parseInt(editTextPrice.getText().toString());

        UserPrefs userPrefs = new UserPrefs(getContext());
        String token = "Bearer " + userPrefs.getToken();


        Call<ResponseBody> call = ApiClient
                .getSINGLETON()
                .getApi()
                .addItem(token, itemTitle, itemDesc, itemPrice);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(getContext(), "Item was added!", Toast.LENGTH_SHORT).show();

                    Fragment newFragment = new ItemsFragment();
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_contatiner, newFragment).commit();
                } else {
                    System.out.println(response.body());
                    Toast.makeText(getContext(), "Sometime you just have to try again", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(getContext(), "NO WORKING MAN", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
