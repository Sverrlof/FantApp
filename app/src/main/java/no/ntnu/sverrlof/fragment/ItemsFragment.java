package no.ntnu.sverrlof.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.Rest.ApiClient;
import no.ntnu.sverrlof.adapter.ItemListAdapter;
import no.ntnu.sverrlof.model.Item;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemsFragment extends Fragment {


    private ArrayList<Item> items = new ArrayList<>();
    private ItemListAdapter adapter;
    private RecyclerView itemRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);

        itemRecyclerView = view.findViewById(R.id.recyclerView);

        setItemsList();

        adapter = new ItemListAdapter(getContext());
        adapter.setItems(items);

        itemRecyclerView.setAdapter(adapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }

    public void setItemsList() {

        Call<List<Item>> call = ApiClient
                .getSINGLETON()
                .getApi()
                .getAllItems();

        call.enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    items = (ArrayList<Item>) response.body();
                    adapter.setItems(items);
                } else {
                    Toast.makeText(getContext(), "Failed to fetch items. Try again", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {

            }
        });
    }


}
