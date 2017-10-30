package de.carey.desigggn.helper;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.carey.desigggn.R;
import de.carey.desigggn.entity.ShotEntity;
import de.hdodenhof.circleimageview.CircleImageView;

public class BindHelper {

    @BindingAdapter("avatarUrl")
    public static void loadAvatar(CircleImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url)
                .apply(
                        new RequestOptions()
                                .placeholder(R.drawable.img_default_avatar)
                                .error(R.drawable.img_default_avatar)
                )
                .into(imageView);
    }

    @BindingAdapter("bindShot")
    public static void loadShot(ImageView target, ShotEntity shot) {
        String url = shot.getImages().getHidpi() == null ? shot.getImages().getNormal() : shot.getImages().getHidpi();
        if (shot.isAnimated())
            if (shot.isAnimated()) {
                Glide.with(target.getContext())
                        .asGif()
                        .load(url)
                        .into(target);
            } else {
                Glide.with(target.getContext())
                        .load(url)
                        .into(target);
            }
    }
}
