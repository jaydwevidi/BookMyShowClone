package com.example.bookmyshowclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class MySliderAdapter extends SliderViewAdapter<MySliderAdapter.MySliderViwHolder> {

    private Context context;
    private List<SliderItem> mSliderItems ;

    public MySliderAdapter(Context context, List<SliderItem> mSliderItems) {
        this.context = context;
        this.mSliderItems = mSliderItems;
    }

    @Override
    public MySliderViwHolder onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_image_slider_layout_item, null);
        return new MySliderViwHolder(inflate);
    }

    @Override
    public void onBindViewHolder(MySliderViwHolder viewHolder, int position) {
        viewHolder.textViewDescription.setText(mSliderItems.get(position).text);

        Glide.with(viewHolder.itemView)
                .load(mSliderItems.get(position).url)
                .fitCenter()
                .into(viewHolder.imageViewBackground);

    }

    @Override
    public int getCount() {
        return mSliderItems.size();
    }

    class MySliderViwHolder extends SliderViewAdapter.ViewHolder{

        View itemView;
        ImageView imageViewBackground;
        ImageView imageGifContainer;
        TextView textViewDescription;

        public MySliderViwHolder(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider);
            imageGifContainer = itemView.findViewById(R.id.iv_gif_container);
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider);
            this.itemView = itemView;
        }
    }

}
