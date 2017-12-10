package com.example.hp.easywallet.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.easywallet.R;
import com.example.hp.easywallet.item;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by HP on 10/12/2560.
 */

public class PayListAdapter extends ArrayAdapter<PayItem> {

    private Context mContext;
    private int mLayoutResId;
    private ArrayList<PayItem> mPayItemList;

    public PayListAdapter(@NonNull Context context, int layoutResId, @NonNull ArrayList<PayItem> PayeItemList) {
        int payItemList;
        super(context, layoutResId, payItemList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mPayItemList = PayeItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        PayItem item = mPayItemList.get(position);

        ImageView payImageView = itemLayout.findViewById(R.id.pay_image_view);
        TextView payTitleTextView = itemLayout.findViewById(R.id.pay_title_text_view);


        payTitleTextView.setText(item.title);

        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            payImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();

            File pictureFile = new File(mContext.getFilesDir(), pictureFileName);
            Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
            payImageView.setImageDrawable(drawable);
        }

        return itemLayout;
    }
}
