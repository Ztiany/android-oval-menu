package com.ztiany.ovalmenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.Random;


/**
 * Author Ztiany                   <br/>
 * Email ztiany3@gmail.com      <br/>
 * Date 2016-04-24 2:14      <br/>
 * Description：
 */
public class OvalMenuFragment extends Fragment implements View.OnClickListener {


    public static OvalMenuFragment newInstance() {
        return new OvalMenuFragment();
    }

    protected OvalMenu mOvalMenu;
    private Random mRandom;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRandom = new Random();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_oval_menu, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.frag_oval_menu_add_long_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_sub_long_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_add_short_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_sub_short_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_hide_show_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_add_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_sub_btn).setOnClickListener(this);
        view.findViewById(R.id.frag_oval_menu_remove_all_btn).setOnClickListener(this);
        mOvalMenu = (OvalMenu) view.findViewById(R.id.frag_oval_menu);
    }

    public void perform(View view) {
        switch (view.getId()) {
            case R.id.frag_oval_menu_add_long_btn: {
                mOvalMenu.setAAxisPercentByHalfWidth(mOvalMenu.getAAxisPercentByHalfWidth() + 0.1F);
                break;
            }
            case R.id.frag_oval_menu_sub_long_btn: {
                mOvalMenu.setAAxisPercentByHalfWidth(mOvalMenu.getAAxisPercentByHalfWidth() - 0.1F);
                break;
            }
            case R.id.frag_oval_menu_add_short_btn: {
                mOvalMenu.setBAxisPercentByAAxis(mOvalMenu.getBAxisPercentByAAxis() + 0.1F);
                break;
            }
            case R.id.frag_oval_menu_sub_short_btn: {
                mOvalMenu.setBAxisPercentByAAxis(mOvalMenu.getBAxisPercentByAAxis() - 0.1F);
                break;
            }
            case R.id.frag_oval_menu_hide_show_btn: {
                mOvalMenu.setDebug(!mOvalMenu.isDebug());
                break;
            }
            case R.id.frag_oval_menu_remove_all_btn: {
                mOvalMenu.removeAllViews();
                break;
            }
            case R.id.frag_oval_menu_add_btn: {
                AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
                appCompatImageView.setImageResource(R.drawable.girl);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                mOvalMenu.addView(appCompatImageView, params);
                break;
            }
            case R.id.frag_oval_menu_sub_btn: {
                if (mOvalMenu.getChildCount() > 0)
                    mOvalMenu.removeViewAt(mRandom.nextInt(mOvalMenu.getChildCount()));
                break;
            }
        }
    }

    @Override
    public void onClick(View v) {
        perform(v);
    }
}
