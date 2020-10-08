package no.ntnu.sverrlof.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import no.ntnu.sverrlof.R;
import no.ntnu.sverrlof.Rest.ApiClient;
import no.ntnu.sverrlof.Rest.FantApi;
import no.ntnu.sverrlof.adapter.ItemListAdapter;
import no.ntnu.sverrlof.model.Item;

public class ItemsFragment extends Fragment {

    private ArrayList<Item> items = new ArrayList<>();
    private ItemListAdapter adapter;
    private RecyclerView itemRecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);

        itemRecyclerView = getActivity().findViewById(R.id.recyclerView);

        adapter = new ItemListAdapter(getContext());
        adapter.setItems(items);

        itemRecyclerView.setAdapter(adapter);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;

    }
    

}
