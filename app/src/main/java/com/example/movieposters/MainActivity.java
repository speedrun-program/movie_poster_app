package com.example.movieposters;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.ArrayList;


/**
 * the main class
 */
public class MainActivity extends AppCompatActivity implements PostersListener {

    private Button buttonAddToWatchlist;


    /**
     * initialization function
     * @param savedInstanceState default parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView postersRecyclerView = findViewById(R.id.postersRecyclerView);
        buttonAddToWatchlist = findViewById(R.id.buttonAddToWatchlist);

        List<Poster> posterList = new ArrayList<>();

        Poster p1 = new Poster();
        p1.image = R.drawable.poster1;
        p1.name = "name1";
        p1.createdBy = "creator1";
        p1.rating = 3.1f;
        p1.story = "story1";
        posterList.add(p1);

        Poster p2 = new Poster();
        p2.image = R.drawable.poster2;
        p2.name = "name2";
        p2.createdBy = "creator2";
        p2.rating = 3.2f;
        p2.story = "story2";
        posterList.add(p2);

        Poster p3 = new Poster();
        p3.image = R.drawable.poster3;
        p3.name = "name3";
        p3.createdBy = "creator3";
        p3.rating = 3.3f;
        p3.story = "story3";
        posterList.add(p3);

        Poster p4 = new Poster();
        p4.image = R.drawable.poster4;
        p4.name = "name4";
        p4.createdBy = "creator4";
        p4.rating = 3.4f;
        p4.story = "story4";
        posterList.add(p4);

        Poster p5 = new Poster();
        p5.image = R.drawable.poster5;
        p5.name = "name5";
        p5.createdBy = "creator5";
        p5.rating = 3.5f;
        p5.story = "story5";
        posterList.add(p5);

        Poster p6 = new Poster();
        p6.image = R.drawable.poster6;
        p6.name = "name6";
        p6.createdBy = "creator6";
        p6.rating = 3.6f;
        p6.story = "story6";
        posterList.add(p6);

        Poster p7 = new Poster();
        p7.image = R.drawable.poster7;
        p7.name = "name7";
        p7.createdBy = "creator7";
        p7.rating = 3.7f;
        p7.story = "story7";
        posterList.add(p7);

        Poster p8 = new Poster();
        p8.image = R.drawable.poster8;
        p8.name = "name8";
        p8.createdBy = "creator8";
        p8.rating = 3.8f;
        p8.story = "story8";
        posterList.add(p8);

        Poster p9 = new Poster();
        p9.image = R.drawable.poster9;
        p9.name = "name9";
        p9.createdBy = "creator9";
        p9.rating = 3.9f;
        p9.story = "story9";
        posterList.add(p9);

        Poster p10 = new Poster();
        p10.image = R.drawable.poster10;
        p10.name = "name10";
        p10.createdBy = "creator10";
        p10.rating = 4.0f;
        p10.story = "story10";
        posterList.add(p10);

        final PosterAdapter posterAdapter = new PosterAdapter(posterList, this);
        postersRecyclerView.setAdapter(posterAdapter);

        buttonAddToWatchlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Poster> selectPosters = posterAdapter.getSelectedPosters();

                StringBuilder posterNames = new StringBuilder();

                for (int i = 0; i < selectPosters.size(); i++) {
                    if (i == 0) {
                        posterNames.append(selectPosters.get(i).name);
                    } else {
                        posterNames.append("\n").append(selectPosters.get(i).name);
                    }
                }

                Toast.makeText(MainActivity.this, posterNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * updates whether or not the poster is selected
     * @param isSelected whether or not the poster is selected
     */
    @Override
    public void onPosterAction(Boolean isSelected) {
        if (isSelected) {
            buttonAddToWatchlist.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchlist.setVisibility(View.GONE);
        }
    }
}