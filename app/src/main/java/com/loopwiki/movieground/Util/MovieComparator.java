package com.loopwiki.movieground.Util;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.loopwiki.movieground.Model.Movie;
/*
    Comparator for comparing Movie object to avoid duplicates
 */
public class MovieComparator extends DiffUtil.ItemCallback<Movie> {
    @Override
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId().equals(newItem.getId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
        return oldItem.getId().equals(newItem.getId());
    }
}
