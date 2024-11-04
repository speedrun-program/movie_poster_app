package com.example.movieposters;


/**
 * poster selection listener interface
 */
public interface PostersListener {

    /**
     * updates whether or not the poster is selected
     * @param isSelected whether or not the poster is selected
     */
    void onPosterAction(Boolean isSelected);
}
