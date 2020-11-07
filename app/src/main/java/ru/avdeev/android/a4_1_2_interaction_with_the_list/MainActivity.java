package ru.avdeev.android.a4_1_2_interaction_with_the_list;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Adapter;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String KEY1="key1";
    private static final String KEY2="key2";
    private ListAdapter listContentAdapter;
    List<Map<String, String>> values;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        listContentAdapter = createAdapter();

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private ListAdapter createAdapter() {
        values= prepareContent(KEY1,KEY2);
        return new SimpleAdapter(this, values, android.R.layout.simple_list_item_2, new String[]{KEY1,KEY2}, new int[]{android.R.id.text1,android.R.id.text2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent(String key1, String key2) {

        List<Map<String,String>> result = new ArrayList<>();
        String[] text=getString(R.string.large_text).split("\n\n");
        List <String> textString = new ArrayList<String>();
        for (int j=0; j<text.length;j++) {
            textString.add(text[j]);
        }
        for (int i=0; i<textString.size(); i++) {
            Map<String, String> map = new HashMap<>();
            map.put(KEY1, textString.get(i));
            map.put(KEY2, textString.get(i).length()+"");
            result.add(map);
        }
        return result;
    }
}