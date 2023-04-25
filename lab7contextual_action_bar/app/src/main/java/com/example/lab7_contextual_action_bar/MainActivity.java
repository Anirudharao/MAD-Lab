package com.example.lab7_contextual_action_bar;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener, ActionMode.Callback{
    private ListView listView;
    private ArrayList<String> itemList;
    private ArrayAdapter<String> adapter;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        itemList = new ArrayList<>();
        itemList.add("Item 1");
        itemList.add("Item 2");
        itemList.add("Item 3");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, itemList);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        if (actionMode != null) {
            return false;
        }

        actionMode = startActionMode(this);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setItemChecked(position, true);

        return true;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        getMenuInflater().inflate(R.menu.contextual_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

//    @Override
//    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_item_delete:
//                int position = listView.getCheckedItemPosition();
//                itemList.remove(position);
//                adapter.notifyDataSetChanged();
//                mode.finish();
//                return true;
//            default:
//                return false;
//        }
//    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_item_delete:
                SparseBooleanArray selected = listView.getCheckedItemPositions();
                for (int i = selected.size() - 1; i >= 0; i--) {
                    if (selected.valueAt(i)) {
                        int position = selected.keyAt(i);
                        if (position != ListView.INVALID_POSITION) {
                            itemList.remove(position);
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                mode.finish();
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {
        actionMode = null;
        listView.clearChoices();
        listView.setChoiceMode(ListView.CHOICE_MODE_NONE);
    }
}