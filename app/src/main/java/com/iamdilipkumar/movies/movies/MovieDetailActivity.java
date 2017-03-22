package com.iamdilipkumar.movies.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Class to show the details of the movie
 * By using the data that was passed from {@link MoviesListActivity#onMovieItemClick(int)}
 *
 * Created on 21/03/2017
 * @author dilipkumar4813
 * @version 1.0
 */
public class MovieDetailActivity extends AppCompatActivity {

    ImageView mPosterImage, mBannerImage;
    TextView mTitleText, mPlotText, mReleaseText, mVoteAverageText, mMovieLanguage;

    String movieVoteAverage, movieLanugage;

    private static final String MOVIE_POSTER = "poster";
    private static final String MOVIE_BANNER = "banner";
    private static final String MOVIE_TITLE = "title";
    private static final String MOVIE_PLOT = "plot";
    private static final String MOVIE_RELEASE = "release";
    private static final String MOVIE_LANGUAGE = "language";
    private static final String MOVIE_AVERAGE_RATING = "average";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        mBannerImage = (ImageView) findViewById(R.id.iv_movie_banner);
        mPosterImage = (ImageView) findViewById(R.id.iv_movie_poster);
        mTitleText = (TextView) findViewById(R.id.tv_movie_title);
        mReleaseText = (TextView) findViewById(R.id.tv_movie_release_date);
        mVoteAverageText = (TextView) findViewById(R.id.tv_movie_average_vote);
        mMovieLanguage = (TextView) findViewById(R.id.tv_movie_language);
        mPlotText = (TextView) findViewById(R.id.tv_movie_plot);

        Intent savedIntent = getIntent();
        if (savedIntent != null && savedIntent.getExtras() != null) {

            if(savedIntent.hasExtra(MOVIE_BANNER)){
                Picasso.with(this).load(savedIntent.getStringExtra(MOVIE_BANNER)).into(mBannerImage);
            }

            if(savedIntent.hasExtra(MOVIE_POSTER)){
                Picasso.with(this).load(savedIntent.getStringExtra(MOVIE_POSTER)).into(mPosterImage);
            }

            if(savedIntent.hasExtra(MOVIE_TITLE)){
                mTitleText.setText(savedIntent.getStringExtra(MOVIE_TITLE));
            }

            if(savedIntent.hasExtra(MOVIE_RELEASE)){
                mReleaseText.setText(savedIntent.getStringExtra(MOVIE_RELEASE));
            }

            if(savedIntent.hasExtra(MOVIE_AVERAGE_RATING)){
                movieVoteAverage = getString(R.string.movie_average_vote) + savedIntent.getStringExtra(MOVIE_AVERAGE_RATING);
                mVoteAverageText.setText(movieVoteAverage);
            }

            if(savedIntent.hasExtra(MOVIE_LANGUAGE)){
                movieLanugage = getString(R.string.movie_language) + savedIntent.getStringExtra(MOVIE_LANGUAGE);
                mMovieLanguage.setText(movieLanugage);
            }

            if(savedIntent.hasExtra(MOVIE_PLOT)){
                mPlotText.setText(savedIntent.getStringExtra(MOVIE_PLOT));
            }
        }
    }
}
