package de.carey.desigggn.widget;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorInt;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.carey.desigggn.R;

public class ColorView extends LinearLayout {

    @ColorInt
    private final int mColor;

    public ColorView(Context context, @ColorInt int color) {
        super(context);
        mColor = color;
        if (!isInEditMode())
            init();
    }

    private void init() {
        View view = inflate(getContext(), R.layout.color_view, this);
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        setPadding(10, 10, 10, 10);

        ImageView imageView = (ImageView) view.findViewById(R.id.image_view);
        TextView textView = (TextView) view.findViewById(R.id.text_view);

        imageView.setImageDrawable(new ColorDrawable(mColor));
        textView.setText(String.format("#%06X", (0xFFFFFF & mColor)));
        textView.setTextColor(mColor);
    }
}
