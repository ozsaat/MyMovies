package com.osaat.mymovies

import android.arch.lifecycle.*
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import android.arch.paging.PagedList
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MovieViewModel(movieRepository: MovieRepository) : ViewModel() {

    var movies = MutableLiveData<List<Movie>>()

    init {
        movies = movieRepository.getPopularMovies()
    }

    fun getMovies(): LiveData<List<Movie>> = movies

//    private val apiKey: String = "bf06c213984ef349e1b70856ae7c1147"
//    private lateinit var movieAdapter: MovieAdapter
//
//    private val compositeDisposable = CompositeDisposable()
//    private val client by lazy { MovieAPI.create() }
//
//    fun getMovies() {
//        compositeDisposable.add(client.getPopularMovies("en", "popularity.desc", apiKey)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { result -> movieAdapter.setData(result) },
//                        { e -> onGetMoviesFailure(e) }
//                )
//        )
//    }
//
//    private fun onGetMoviesFailure(e: Throwable?) {
//        Log.e(e?.message, e?.stackTrace.toString())
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        compositeDisposable.dispose()
//    }
}

//class MovieViewModel : ViewModel(), LifecycleObserver {
//
//    private val apiKey: String = "bf06c213984ef349e1b70856ae7c1147"
//
//    private val client by lazy { MovieAPI.create() }
//    private lateinit var movieAdapter: MovieAdapter
//
//    private var disposable: Disposable? = null
//
//    // Holds a list of movie data which can be observed and changed
//    private var moviesLiveData = MutableLiveData<List<Movie>>()
//
//    val movies: MutableLiveData<List<Movie>> = MutableLiveData()
//
//
//    // Holds state of loading
//    private val loadingMovieLiveData = MutableLiveData<Boolean>()
//
//    // Observable ListData of movies
//    fun getMovies(): LiveData<List<Movie>> {
//        return moviesLiveData
//    }
//
//    // Indicator to show/hide loading information
//    fun isLoading(): LiveData<Boolean> {
//        return loadingMovieLiveData
//    }
//
//    // Sets movie list content
//    fun setMovies() {
//        this.moviesLiveData.value = showMovies()
//    }
//
//    // Sets the loading state
//    fun setLoading(loadingMovieLiveData: Boolean) {
//        this.loadingMovieLiveData.value = loadingMovieLiveData
//    }
//
//    private fun showMovies(): List<Movie>? {
//
//        disposable = client.getPopularMovies("en", "popularity.desc", apiKey)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        { result -> movieAdapter.setData(result) },
//                        { e -> onGetMoviesFailure(e) }
//                )
//        return showMovies()
//    }
//
//    private fun onGetMoviesFailure(e: Throwable?) {
//        Log.e(e?.message, e?.stackTrace.toString())
//    }
//
//    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
//    fun onResume() { getMovies() }
//
//}