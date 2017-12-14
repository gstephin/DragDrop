package baashaa.modelclasses;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Stephin on 09-Dec-17.
 **/

public class RecyclerQuestionAdapter extends RecyclerView.Adapter<RecyclerQuestionAdapter.MyViewHolder> implements View.OnTouchListener {
    Context context;
    List<BaashaaQuiz> quizes;
    View itemView;

    public RecyclerQuestionAdapter(Context context, List<BaashaaQuiz> quizes) {
        this.quizes = quizes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_single_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        BaashaaQuiz baashaaQuiz = quizes.get(position);
        List<BaashaaImage> images =baashaaQuiz.getImages();
        BaashaaImage image = images.get(position);
        holder.imageView.setImageResource(image.getUrl());
        holder.fram_lay.setTag(position);
        holder.fram_lay.setOnTouchListener(this);

    }

    @Override
    public int getItemCount() {
        return quizes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        FrameLayout fram_lay;

        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image);
            fram_lay = view.findViewById(R.id.fram_lay);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                ClipData data = ClipData.newPlainText("", "");
                View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    v.startDragAndDrop(data, shadowBuilder, v, 0);
                } else {
                    v.startDrag(data, shadowBuilder, v, 0);
                }
                return true;
        }
        return false;
    }

}
