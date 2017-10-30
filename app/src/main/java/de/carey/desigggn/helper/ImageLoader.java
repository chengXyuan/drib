package de.carey.desigggn.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import de.carey.desigggn.entity.ShotEntity;

public class ImageLoader {

    public static void loadShot(Context context, ShotEntity shot, ImageView imageView) {
        if (shot.isAnimated()) {
            Glide.with(context)
                    .asGif()
                    .load(shot.getImages().getNormal())
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(shot.getImages().getNormal())
                    .into(imageView);
        }
    }
}
