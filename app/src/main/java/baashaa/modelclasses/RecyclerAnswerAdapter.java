package baashaa.modelclasses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stephin on 09-Dec-17.
 **/

public class RecyclerAnswerAdapter extends RecyclerView.Adapter<RecyclerAnswerAdapter.MyViewHolder> {
    Context context;
    List<BaashaaQuiz> titleList;
    View itemView;
    private Listener listener;
    int[] imageArray;
    public boolean isDropped = false;
    ArrayList<Integer> checkList = new ArrayList<>();
    BaashaaQuiz baashaaQuiz;
    public RecyclerAnswerAdapter(Context context, List<BaashaaQuiz> restList, Listener listener, int[] imageArray) {
        this.titleList = restList;
        this.context = context;
        this.listener = listener;
        this.imageArray = imageArray;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.title_single_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        baashaaQuiz = titleList.get(position);
        holder.title.setText(baashaaQuiz.getEntityName());
        holder.drag_layout.setOnDragListener(new DragListener(listener, holder));
        holder.drag_layout.setTag(baashaaQuiz.getEntityId());
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        LinearLayout drag_layout;
        ImageView dropImage;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            drag_layout = view.findViewById(R.id.frame_layout_item);
            dropImage = view.findViewById(R.id.imagedrop);

        }
    }

    public class DragListener implements View.OnDragListener {

        private Listener listener;
        private static final String TAG = "TrashDragListener";
        private boolean hit;
        MyViewHolder viewHolder;

        DragListener(Listener listener, MyViewHolder viewHolder) {
            this.listener = listener;
            this.viewHolder = viewHolder;
        }

        @Override
        public boolean onDrag(View v, DragEvent event) {
            switch (event.getAction()) {
                case DragEvent.ACTION_DROP:
                    isDropped = true;
                    int entityID = -1;

                    View viewSource = (View) event.getLocalState();
                    int viewId = v.getId();
                    final int flItem = R.id.frame_layout_item;
                    final int recyclerTitle = R.id.recyclerTitle;
                    final int recyclerImage = R.id.recyclerImage;


                    switch (viewId) {
                        case flItem:
                            RecyclerView target;
                            switch (viewId) {
                                case flItem:
                                    target = v.getRootView().findViewById(recyclerImage);
                                    entityID = (int) v.getTag();
                                    Log.d("entityID", String.valueOf(entityID));

                                    if (checkList.size() <= titleList.size()-1) {
                                        checkList.add(entityID);
                                        listener.addArrayList(checkList);
                                        for (Integer i : checkList) {
                                            Log.d(TAG, "array >> " + i);
                                        }
                                        break;
                                    }


                                    break;

                                default:
                                    target = (RecyclerView) v.getParent();
                            }

                            if (viewSource != null) {
                                RecyclerView source = (RecyclerView) viewSource.getParent();
                                RecyclerQuestionAdapter adapterSource = (RecyclerQuestionAdapter) source.getAdapter();
                                int sourceID = (int) viewSource.getTag();
                                viewHolder.dropImage.setImageResource(imageArray[sourceID]);
                                List<BaashaaImage> images =baashaaQuiz.getImages();
                                BaashaaImage image = images.get(sourceID);
                                int imageID = image.getId();
                                Log.d(TAG, "imageID" + imageID);
                                adapterSource.notifyDataSetChanged();


                            }
                            break;
                    }
                    break;
            }

            if (!isDropped && event.getLocalState() != null) {
                ((View) event.getLocalState()).setVisibility(View.VISIBLE);
            }
            return true;
        }
    }

}
