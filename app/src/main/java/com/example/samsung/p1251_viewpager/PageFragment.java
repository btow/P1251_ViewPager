package com.example.samsung.p1251_viewpager;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;
import java.util.zip.Inflater;

/**
 * Created by samsung on 18.05.2017.
 */

public class PageFragment extends Fragment {

    public static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    private int pageNumber, backColor;

    public static final PageFragment newInstance(final int page) {

        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        Random rnd = new Random();
        backColor = Color.argb(40, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, null);

        TextView tvPage = (TextView) view.findViewById(R.id.tvPage);
        String text1 = "", text2 = "Page " + pageNumber + ". ";
        for (int i = 0; i < 100; i++) {
            if (i%15 == 0) {
                text1 += "\n";
            }
            text1 += text2;
        }
        tvPage.setText(text1);
        tvPage.setBackgroundColor(backColor);
        tvPage.setMovementMethod(new ScrollingMovementMethod());

        return view;
    }
}
