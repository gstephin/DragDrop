package baashaa.modelclasses;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Listener {
    RecyclerView recyclerViewTitle, recyclerViewImage;
    final String TAG = getClass().getSimpleName();
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.LayoutManager layoutManager;


    RecyclerQuestionAdapter recyclerQuestionAdapter;
    RecyclerAnswerAdapter recyclerAnswerAdapter;
    List<BaashaaImage> images = new ArrayList<>();
    Button reset_button, check_button;
    List<BaashaaQuiz> quizes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewTitle = findViewById(R.id.recyclerTitle);
        recyclerViewImage = findViewById(R.id.recyclerImage);
        reset_button = findViewById(R.id.reset_button);
        check_button = findViewById(R.id.check_button);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        String[] entityName = new String[]{"man", "dog", "walking", "women"};
        int[] imageUrl = new int[]{R.drawable.hiker, R.drawable.girl, R.drawable.boy, R.drawable.dog};
        List<BaashaaImage> images = new ArrayList<>();
        int[] mainId= new int[]{5,9,2,6};
        for (int i = 0; i < 4; i++) {
            BaashaaQuiz quiz = new BaashaaQuiz();
            quiz.setQuizType(QuizType.QUIZE_TYPE_IMAGE_TO_TEXT);
            quiz.setEntityId(mainId[i]);
            quiz.setEntityName(entityName[i]);
            BaashaaImage image = new BaashaaImage();

            image.setId(mainId[i]);
            image.setUrl(imageUrl[i]);
            images.add(image);
            quiz.setImages(images);
            quizes.add(quiz);
        }


        recyclerAnswerAdapter = new RecyclerAnswerAdapter(MainActivity.this, quizes, this, imageUrl);
        recyclerViewTitle.setLayoutManager(mLayoutManager);
        recyclerViewTitle.setItemAnimator(new DefaultItemAnimator());
        recyclerViewTitle.setAdapter(recyclerAnswerAdapter);
        recyclerAnswerAdapter.notifyDataSetChanged();
        Log.d(TAG, "Dummy quiz questions created : " + quizes.size());

        new ImageAsync().execute();
        reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0);
                startActivity(getIntent());
                overridePendingTransition(0, 0);
            }
        });
        check_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void addArrayList(ArrayList<Integer> arrayList) {

    }

    public class ImageAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                recyclerQuestionAdapter = new RecyclerQuestionAdapter(MainActivity.this, quizes);
                recyclerViewImage.setLayoutManager(layoutManager);
                recyclerViewImage.setItemAnimator(new DefaultItemAnimator());
                recyclerViewImage.setAdapter(recyclerQuestionAdapter);
                recyclerQuestionAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
