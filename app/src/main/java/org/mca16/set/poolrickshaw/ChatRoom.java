package org.mca16.set.poolrickshaw;

import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.dao.ThreadMetaValue;
import co.chatsdk.core.dao.User;

public class ChatRoom{
    private Thread mThread;
    private static final String META_SOURCE_KEY = "Source";
    private static final String META_DESTINATION_KEY = "Destination";
    private static final String META_CAPACITY_KEY = "Capacity";
    private static final String META_SIZE_KEY = "Size";


    public ChatRoom(Thread thread){
        this.mThread = thread;

        if( mThread.metaValueForKey(META_SIZE_KEY) == null ) {
            mThread.setMetaValue(META_SIZE_KEY, String.valueOf(0));
        }
    }

    public String getSource(){
        return mThread.metaValueForKey(META_SOURCE_KEY).getValue();
    }

    public String getDestination(){
        return mThread.metaValueForKey(META_DESTINATION_KEY).getValue();
    }

    public int getCapacity(){
        return Integer.parseInt( mThread.metaValueForKey(META_CAPACITY_KEY).getValue() );
    }

    public int getSize(){
        return Integer.parseInt( mThread.metaValueForKey(META_SIZE_KEY).getValue() );
    }

    public void setSource(String sourceStation){
        mThread.setMetaValue(META_SOURCE_KEY, sourceStation);
    }

    public void setDestination(String destinationStation){
        mThread.setMetaValue(META_DESTINATION_KEY, destinationStation);
    }

    public void setCapacity(int capacity){
        mThread.setMetaValue(META_CAPACITY_KEY, String.valueOf(capacity));
    }

}
