package com.example.tretiakoff.sifg2.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tretiakoff.sifg2.R;
import com.example.tretiakoff.sifg2.api.model.chat.Answer;
import com.example.tretiakoff.sifg2.api.model.chat.Pathology;

import java.util.ArrayList;

/**
 * Created by tretiakoff on 05/07/2018.
 */

public class PathologyAdapter extends RecyclerView.Adapter<PathologyAdapter.PathologyHolder> {
    private ArrayList<Pathology> mPathologyList = new ArrayList<>();
    private LayoutInflater topRatedInflater;
    private PathologyAdapter.OnBtnClickListener mOnBtnClickListener;

    public PathologyAdapter(PathologyAdapter.OnBtnClickListener mOnBtnClickListener) {
        this.mOnBtnClickListener = mOnBtnClickListener;
    }

    @Override
    public PathologyAdapter.PathologyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View topRatedRl = topRatedInflater.from(parent.getContext()).inflate(R.layout.item_pathology, parent, false);
        return new PathologyAdapter.PathologyHolder(topRatedRl);
    }

    @Override
    public void onBindViewHolder(PathologyAdapter.PathologyHolder holder, final int position) {

        final Pathology mPathology = mPathologyList.get(position);
        holder.label.setText(mPathology.getLabel());


        holder.btnContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnBtnClickListener.onBtnClick(mPathology);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mPathologyList.size();
    }

    public void setTopRatedList(ArrayList<Pathology> pathologyList) {

        mPathologyList = pathologyList;
    }

    public interface OnBtnClickListener {
        void onBtnClick(Pathology pathology);
    }

    public static class PathologyHolder extends RecyclerView.ViewHolder {

        private TextView label;
        RelativeLayout btnContainer;

        PathologyHolder(View btnViewItemLayout) {
            super(btnViewItemLayout);
            btnContainer = (RelativeLayout) btnViewItemLayout;
            label = btnViewItemLayout.findViewById(R.id.pathology_label);
        }
    }
}
