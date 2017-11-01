package de.carey.desigggn.ui.adapter;

import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.DateFormat;

import de.carey.desigggn.R;
import de.carey.desigggn.entity.CommentEntity;
import de.carey.desigggn.util.HtmlUtils;
import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends BaseQuickAdapter<CommentEntity, BaseViewHolder> {

    public CommentAdapter() {
        super(R.layout.item_shot_comment);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommentEntity item) {
        CircleImageView ivAvatar = helper.getView(R.id.iv_avatar);
        Glide.with(mContext).load(item.getUser().getAvatarUrl()).into(ivAvatar);
        helper.setText(R.id.tv_user_name, item.getUser().getName());
        TextView tvCommentBody = helper.getView(R.id.tv_comment_body);
        HtmlUtils.Html2StringNoP(tvCommentBody, item.getBody());
        helper.setText(R.id.tv_comment_time, DateFormat.getDateTimeInstance().format(item.getCreatedAt()));
        helper.setText(R.id.tv_comment_like_count, String.valueOf(item.getLikesCount()));
    }
}
