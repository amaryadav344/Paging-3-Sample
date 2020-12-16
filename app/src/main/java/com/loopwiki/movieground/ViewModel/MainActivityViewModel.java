package com.loopwiki.movieground.ViewModel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import com.loopwiki.movieground.Model.Movie;
import com.loopwiki.movieground.Paging.MoviePagingSource;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

/*
    ViewModel for MainActivity
 */
public class MainActivityViewModel extends ViewModel {
    // Define Flowable for movies
    public Flowable<PagingData<Movie>> pagingDataFlow;

    public MainActivityViewModel() {
        init();
    }

    // Init ViewModel Data
    private void init() {
        // Define Paging Source
        MoviePagingSource moviePagingSource = new MoviePagingSource();

        // Create new Pager
        Pager<Integer, Movie> pager = new Pager(
                // Create new paging config
                new PagingConfig(20, // pageSize - Count of items in one page
                        20, // prefetchDistance - Number of items to prefetch
                        false, // enablePlaceholders - Enable placeholders for data which is not yet loaded
                        20, // initialLoadSize - Count of items to be loaded initially
                        20 * 499),// maxSize - Count of total items to be shown in recyclerview
                () -> moviePagingSource); // set paging source

        // inti Flowable
        pagingDataFlow = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(pagingDataFlow, coroutineScope);

    }
}
