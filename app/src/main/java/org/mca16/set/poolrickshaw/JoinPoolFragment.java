package org.mca16.set.poolrickshaw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.chatsdk.core.dao.User;
import co.chatsdk.ui.main.BaseFragment;
import co.chatsdk.ui.profile.ProfileFragment;

public class JoinPoolFragment extends BaseFragment {

    @Override
    public void clearData() {

    }

    @Override
    public void reloadData() {

    }

    public static JoinPoolFragment newInstance() {
        JoinPoolFragment f = new JoinPoolFragment();

        f.setRetainInstance(true);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mainView = inflater.inflate(R.layout.fragment_join_pool, null);

        return mainView;
    }
}
