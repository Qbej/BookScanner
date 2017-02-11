package com.soldiersofmobile.bookscanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.soldiersofmobile.bookscanner.api.model.VolumeInfo;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookDetailsActivity extends AppCompatActivity {

    @BindView(R.id.cover)
    ImageView cover;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.author)
    TextView author;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.activity_book_details)
    LinearLayout activityBookDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        ButterKnife.bind(this);

        VolumeInfo volumeInfo
                = (VolumeInfo) getIntent()
                .getSerializableExtra(BookScannerActivity.VOLUME_INFO_EXTRA);

        title.setText(volumeInfo.getTitle());
        subtitle.setText(volumeInfo.getSubtitle());
        description.setText(volumeInfo.getDescription());

        StringBuilder authors = new StringBuilder();
        for (String singleAuthor : volumeInfo.getAuthors()) {
            authors.append(singleAuthor);
            authors.append(" ");
        }

        author.setText(authors);

        Picasso.with(this)
                .load(volumeInfo.getImageLinks().getThumbnail())
                .placeholder(R.drawable.ic_placeholder)
                .into(cover);


    }
}
