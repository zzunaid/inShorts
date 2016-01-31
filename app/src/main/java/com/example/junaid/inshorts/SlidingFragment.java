package com.example.junaid.inshorts;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.junaid.inshorts.helpers.ImageHelper;
import com.facebook.drawee.view.SimpleDraweeView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by junaid on 28/01/16.
 */
public class SlidingFragment extends Fragment {

    private AppData mAppData;
    private int mPosition;


    public interface AppData {
        JSONObject getData(int position);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mAppData = (AppData) context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        populateData();
    }

    private void populateData(){
        String body;
        String imageUrl;
        JSONObject jsonObject = mAppData.getData(getArguments().getInt("position"));
        try {
            body = jsonObject.getString("body");
            imageUrl = jsonObject.getString("image_url");
            ((TextView) getView().findViewById(R.id.text)).setText(body);

            Uri uri = Uri.parse(imageUrl);
            SimpleDraweeView draweeView = (SimpleDraweeView) getView().findViewById(R.id.image);
            draweeView.setImageURI(uri);

//            ImageHelper.getInstance().displayImage(imageUrl, (ImageView) getView().findViewById(R.id.image));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
