package org.mca16.set.poolrickshaw;

import java.util.ArrayList;
import java.util.List;

import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.handlers.ThreadHandler;
import co.chatsdk.core.interfaces.ThreadType;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.ui.threads.PublicThreadsFragment;

public class PoolRickshawPublicThreadsFragment extends PublicThreadsFragment {
    @Override
    protected List<Thread> getThreads() {
        ThreadHandler handler = ChatSDK.thread();

        List<Thread> threads = new ArrayList<>();

        for( Thread thread : ChatSDK.thread().getThreads(ThreadType.Public) ){
            if( thread.getUsers().contains(ChatSDK.currentUser()) ){
                threads.add(thread);
            }
        }
        return threads;
    }
}
