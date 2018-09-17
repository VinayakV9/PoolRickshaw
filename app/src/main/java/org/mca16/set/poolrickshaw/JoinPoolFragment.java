package org.mca16.set.poolrickshaw;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.dao.User;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.ui.main.BaseFragment;
import co.chatsdk.ui.profile.ProfileFragment;
import java.util.*;
import android.widget.TextView;


public class JoinPoolFragment extends BaseFragment {

    @Override
    public void clearData() {

    }

    public void onSearchPressed(){
        for( Thread thread : ChatSDK.thread().getThreads(1)){
            TextView sourceTextView = getActivity().findViewById(R.id.join_pool_source_station);
            TextView destinationTextView = getActivity().findViewById(R.id.join_pool_destination_station);



            String sourceEntered = sourceTextView.getText().toString();
            String destinationEntered = destinationTextView.getText().toString();
            Log.d("source entered", sourceEntered);
            Log.d("destination entered", destinationEntered);


            Log.d("Thread","--------Name:"+thread.getName()+"-----EntityId:"+thread.getEntityID()+"-------");
        }
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
