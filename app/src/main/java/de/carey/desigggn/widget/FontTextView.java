package de.carey.desigggn.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.SparseArray;

import de.carey.desigggn.R;

public class FontTextView extends AppCompatTextView {

    private static final SparseArray<String> FONT_ARRAY;
    private static final int CAPACITY = 4;
    private static final int CACHE_SIZE = CAPACITY * 250000;
    private static LruCache<String, Typeface> sFontCache;

    static {
        FONT_ARRAY = new SparseArray<>(CAPACITY);
        sFontCache = new LruCache<>(CACHE_SIZE);

        FONT_ARRAY.put(0, "fonts/OpenSans-Light.ttf");
        FONT_ARRAY.put(1, "fonts/OpenSans-Regular.ttf");
        FONT_ARRAY.put(2, "fonts/OpenSans-Semibold.ttf");
        FONT_ARRAY.put(3, "fonts/OpenSans-Bold.ttf");
    }

    public FontTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.FontTextView,
                0, 0);

        String fontKey;
        try {
            fontKey = FONT_ARRAY.get(a.getInteger(R.styleable.FontTextView_weight, 1));
        } finally {
            a.recycle();
        }

        Typeface typeface;
        if (sFontCache.get(fontKey) == null) {
            typeface = Typeface.createFromAsset(getContext().getAssets(), fontKey);
            sFontCache.put(fontKey, typeface);
        } else {
            typeface = sFontCache.get(fontKey);
        }

        setTypeface(typeface);
    }
}
