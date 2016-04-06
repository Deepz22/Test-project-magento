package com.example.subhashvaikunth.testproject2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class ADPTList extends BaseAdapter{

    private Context context;
    private List<String> selectedItemsList;

    UpdateCart mCallback;

    public interface UpdateCart {
        void removeFromCart(String name);
    }

    public ADPTList(Context context, List<String> selectedItemsList, UpdateCart mCallback) {
        this.context =context;
        this.selectedItemsList = selectedItemsList;
        this.mCallback = mCallback;
    }

    @Override
    public int getCount() {
        return selectedItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return selectedItemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final String itemName = (String) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.uiTV);
        tv.setText(itemName);
        Button   btn = (Button) convertView.findViewById(R.id.uiBtnRemove);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.removeFromCart(itemName);
            }
        });
        return convertView;
    }
}
