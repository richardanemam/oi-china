package com.example.richard.oichina;

        import android.provider.Contacts;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.widget.ImageView;

        import com.bumptech.glide.Glide;

        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        List<Lesson> lessons = setOfLessons();
        recyclerView.setAdapter(new LessonAdapter(lessons, this));

        try {
            Glide.with(this).load(R.drawable.alexander_ramsey).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Lesson> setOfLessons(){
        int thumbnails[] = {R.drawable.salty_justice, R.drawable.thong_vo, R.drawable.yogurt_yogurt, R.drawable.yasmin_dangor, R.drawable.chuttersnap};

        String lessonTitle[] = {"Lição 0: Pinyin", "Lição 1: Qual o seu nome ?", "Lição 2: Prazer em conhecê-lo", "Lição 3: Fimília",
                                "Lição 4: Mapas"};
        String description[] = {"Introdução a Fonética", "第一课: 您贵姓？", " 第二课: 认识你很高兴。", "第三课: 你家有几口人。", "第四课: 这张地图是葡萄牙文的。" };

        List<Lesson> lessonList = new ArrayList<>();

        for(int i = 0; i < thumbnails.length; i++){
            Lesson lesson = new Lesson(thumbnails[i], lessonTitle[i], description[i]);
            lessonList.add(lesson);
        }

        return lessonList;
    }
}
