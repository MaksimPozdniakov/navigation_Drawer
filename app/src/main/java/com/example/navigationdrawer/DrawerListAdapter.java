package com.example.navigationdrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class DrawerListAdapter extends ArrayAdapter<String> {
    private final Context mContext;
    private final int mLayoutResId;
    private final List<String> mItems;

    public DrawerListAdapter(Context context, int layoutResId, List<String> items) {
        super(context, layoutResId, items);
        mContext = context;
        mLayoutResId = layoutResId;
        mItems = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mLayoutResId, parent, false);

            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.item_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (mItems != null && !mItems.isEmpty()) {
            String item = mItems.get(position);
            if (holder.textView != null && item != null) {
                holder.textView.setText(item);
            }
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView textView;
    }
}



