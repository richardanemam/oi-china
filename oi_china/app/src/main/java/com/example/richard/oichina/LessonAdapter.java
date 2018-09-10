package com.example.richard.oichina;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Richard on 9/8/2018.
 */

public class LessonAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Lesson> lessons;

    public LessonAdapter(List<Lesson> lessons, Context context){
        this.context = context;
        this.lessons = lessons;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lesson_card_view, parent, false);
        return new LessonHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        final LessonHolder lessonHolder = (LessonHolder) holder;

        Lesson lesson = lessons.get(position);

        lessonHolder.lesson_title.setText(lesson.getLessonTitle());
        lessonHolder.description.setText(lesson.getDescription());

        //Loading the thumbnail
        Glide.with(this.context).load(lesson.getThumbnail()).into(lessonHolder.thumbnail);

        lessonHolder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(lessonHolder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.lessons.size();
    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(this.context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_view, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(context, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

    public class LessonHolder extends RecyclerView.ViewHolder{

        TextView lesson_title;
        TextView description;
        ImageView thumbnail;
        ImageView overflow;

        public LessonHolder(View itemView) {
            super(itemView);

            lesson_title = itemView.findViewById(R.id.lesson_title);
            description = itemView.findViewById(R.id.description);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            overflow = itemView.findViewById(R.id.overflow);

        }
    }
}
