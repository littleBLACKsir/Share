package com.example.myapplication3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dueeeke.videocontroller.component.PrepareView;
import com.example.myapplication3.R;
import com.example.myapplication3.entity.PictureEntity;
import com.example.myapplication3.view.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<PictureEntity> datas;

    public void setDatas(List<PictureEntity> datas) {
        this.datas = datas;
    }

    public VideoAdapter(Context context) {
        this.mContext = context;
    }

    public VideoAdapter(Context context, List<PictureEntity> datas) {
        this.datas = datas;
        this.mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_picture, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,int position) {
        ViewHolder vh = (ViewHolder) holder;
        PictureEntity videoEntity = datas.get(position);
        vh.tvTitle.setText(videoEntity.getPicturename());
        vh.tvAuthor.setText(videoEntity.getUsername());
        vh.tvDz.setText(String.valueOf(videoEntity.getDianzan()));
        Picasso.with(mContext)
                .load(videoEntity.getUrl())
                .into(vh.Cover);
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        } else
            return 0;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle;
        private TextView tvAuthor;
        private TextView tvDz;
        private TextView tvComment;
        private TextView tvCollect;
        private ImageView img_header;
        public ImageView Cover;
        public int mPosition;
        public PrepareView mPrepareView;
        public FrameLayout mPlayerContainer;

        public ViewHolder(@NonNull View view) {
            super(view);
            tvTitle = view.findViewById(R.id.title);
            tvAuthor = view.findViewById(R.id.author);
            tvDz = view.findViewById(R.id.dianzan);
            tvCollect = view.findViewById(R.id.collect);
            tvComment = view.findViewById(R.id.comment);
            img_header = view.findViewById(R.id.img_header);
            Cover = view.findViewById(R.id.img_cover);
        }

    }
}

