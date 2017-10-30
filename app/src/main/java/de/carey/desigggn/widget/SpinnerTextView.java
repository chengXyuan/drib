package de.carey.desigggn.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import de.carey.desigggn.R;
import de.carey.desigggn.entity.SelectorEntity;
import de.carey.desigggn.widget.easypopup.EasyPopup;
import de.carey.desigggn.widget.easypopup.HorizontalGravity;
import de.carey.desigggn.widget.easypopup.VerticalGravity;

public class SpinnerTextView extends AppCompatTextView implements View.OnClickListener {

    private int mIconPadding;
    private Rect mRect;
    private EasyPopup mPopDropDown;
    private int mDrawableWidth;
    private BaseQuickAdapter<SelectorEntity, BaseViewHolder> mAdapter;

    public SpinnerTextView(Context context) {
        this(context, null);
    }

    public SpinnerTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SpinnerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.SpinnerTextView);
        mIconPadding = typedArray.getDimensionPixelSize(R.styleable.SpinnerTextView_icon_padding, 0);
        typedArray.recycle();

        mRect = new Rect();
        setIconPadding(mIconPadding);

        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        mAdapter = new BaseQuickAdapter<SelectorEntity, BaseViewHolder>(R.layout.item_spinner_home) {
            @Override
            protected void convert(BaseViewHolder helper, SelectorEntity item) {
                helper.setText(R.id.tv_item_spinner, item.getDesc());
            }
        };
        recyclerView.setAdapter(mAdapter);

        mPopDropDown = new EasyPopup(context)
                .setContentView(recyclerView)
                .setAnimationStyle(R.style.AnimDown)
                .setFocusAndOutsideEnable(true);

        setOnClickListener(this);
    }

    public void setIconPadding(int padding) {
        mIconPadding = padding;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mPopDropDown.setWidth(MeasureSpec.getSize(widthMeasureSpec));
        mPopDropDown.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        Paint textPaint = getPaint();
        String text = getText().toString();
        textPaint.getTextBounds(text, 0, text.length(), mRect);

        int textWidth = mRect.width();
        int contentWidth = mDrawableWidth + mIconPadding * 2 + textWidth;
        int horizontalPadding = (int) ((getWidth() / 2.0) - (contentWidth / 2.0));

        setCompoundDrawablePadding(-horizontalPadding + mIconPadding);

        setPadding(0, getPaddingTop(), horizontalPadding, getPaddingBottom());
    }

    @Override
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawablesWithIntrinsicBounds(left, top, right, bottom);
        if (right != null) {
            mDrawableWidth = right.getIntrinsicWidth();
        }
        requestLayout();
    }

    @Override
    public void onClick(View v) {
        mPopDropDown.createPopup()
                .showAtAnchorView(this, VerticalGravity.BELOW, HorizontalGravity.CENTER);
    }

    public void setItem(List<SelectorEntity> item, OnItemSelectedListener listener) {
        mAdapter.setNewData(item);
        mAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mPopDropDown.dismiss();
                SelectorEntity item = mAdapter.getData().get(position);
                if (!item.getDesc().equals(getText())) {
                    setText(item.getDesc());
                    listener.onSpinnerItemSelected(SpinnerTextView.this, position, item.getValue());
                }
            }
        });
    }


    public interface OnItemSelectedListener {
        void onSpinnerItemSelected(View view, int position, String item);
    }
}
