package com.example.junaid.inshorts.helpers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Created by junaid on 27/01/16.
 *      ImageHelper.getInstance().init(getApplicationContext());
 *      ImageHelper.getInstance().displayImage(imageUrl, (ImageView) getView().findViewById(R.id.image));
 */
public class ImageHelper {

    private static ImageHelper mInstance;
    private ImageLoader mImageLoader;

    private ImageHelper() {
        mImageLoader = ImageLoader.getInstance();
    }

    public void init(Context context) {
        mImageLoader.init(ImageLoaderConfiguration.createDefault(context));
    }

    public static ImageHelper getInstance() {
        if (mInstance == null)
            mInstance = new ImageHelper();
        return mInstance;
    }

    public void displayImage(String imageUrl, ImageView imageView) {
        if (imageUrl == null || imageUrl.isEmpty())
            return;
        mImageLoader.displayImage(imageUrl, imageView);
    }

}
