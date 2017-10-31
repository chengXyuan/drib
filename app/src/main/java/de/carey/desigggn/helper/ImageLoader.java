package de.carey.desigggn.helper;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import de.carey.desigggn.entity.ImageEntity;
import de.carey.desigggn.entity.ShotEntity;

public class ImageLoader {

    public static void loadShot(ShotEntity shot, ImageView imageView) {
        ImageEntity image = shot.getImages();
        String url = TextUtils.isEmpty(image.getHidpi()) ? image.getNormal() : image.getHidpi();
        /*if (shot.isAnimated()) {
            Glide.with(imageView.getContext())
                    .asGif()
                    .load(url)
                    .apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                    .into(imageView);
        } else {*/
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
        //}
    }
}
