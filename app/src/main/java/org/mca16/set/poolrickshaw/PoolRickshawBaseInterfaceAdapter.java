package org.mca16.set.poolrickshaw;

import android.content.Context;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import co.chatsdk.core.Tab;
import co.chatsdk.ui.manager.BaseInterfaceAdapter;

public class PoolRickshawBaseInterfaceAdapter extends BaseInterfaceAdapter {
    public PoolRickshawBaseInterfaceAdapter(Context context) {
        super(context);
    }

    @Override
    public List<Tab> defaultTabs() {

        ArrayList<Tab> tabs = new ArrayList<>();
        tabs.add(joinPoolTab());
        tabs.add(publicThreadsTab());
        tabs.add(profileTab());

        return tabs;
    }

    private Tab joinPoolTab() {
        return new Tab("Join Pool", android.R.drawable.arrow_down_float , joinPoolFragment());
    }

    private Fragment joinPoolFragment() {
        return JoinPoolFragment.newInstance();
    }

    @Override
    public Fragment publicThreadsFragment(){
        return new PoolRickshawPublicThreadsFragment();
    }
}
