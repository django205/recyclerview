package com.examle.yogeshkumar.recyclerview.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.examle.yogeshkumar.recyclerview.R;
import com.examle.yogeshkumar.recyclerview.model.Listitem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yogesh Kumar on 2/14/2017.
 */

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder> {

    private List<Listitem> listdata;
    private LayoutInflater inflater;
    private ItemClickCallback itemClickCallback;

    public interface ItemClickCallback {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public DerpAdapter(List<Listitem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listdata = listData;
    }


    public void setListData(ArrayList<Listitem> exerciseList) {
        this.listdata.clear();
        this.listdata.addAll(exerciseList);
    }
    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.list_item,parent,false);

        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        Listitem item = listdata.get(position);
        holder.title.setText(item.getTitle());
        holder.subtitle.setText(item.getSubTitle());
        if (item.isFavourite()){
            holder.secondaryicon.setImageResource(R.drawable.ic_star_black_24dp);
        } else {
            holder.secondaryicon.setImageResource(R.drawable.ic_star_border_black_24dp);
        }
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView title;
        private ImageView thumbnail;
        private TextView subtitle;
        private ImageView secondaryicon;
        private View container;

        public DerpHolder(View itemView) {
            super(itemView);

            title= (TextView)itemView.findViewById(R.id.lbl_item_text);
            thumbnail=(ImageView)itemView.findViewById(R.id.im_item_icon);
            subtitle= (TextView)itemView.findViewById(R.id.lbl_item_sub_title);
            secondaryicon=(ImageView)itemView.findViewById(R.id.im_item_icon_secondary);
            secondaryicon.setOnClickListener(this);
            container=itemView.findViewById(R.id.cont_item_root);

            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.cont_item_root){
                itemClickCallback.onItemClick(getAdapterPosition());
            } else {
                itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }

        }
    }


}
