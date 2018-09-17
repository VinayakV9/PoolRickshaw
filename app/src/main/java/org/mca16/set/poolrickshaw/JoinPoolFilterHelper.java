package org.mca16.set.poolrickshaw;

import java.util.ArrayList;
import java.util.List;

import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.interfaces.ThreadType;
import co.chatsdk.core.session.ChatSDK;

public class JoinPoolFilterHelper {

    public static List<ChatRoom> search(String source, String destination){
        List<ChatRoom> result = new ArrayList<>();

        for(Thread thread : ChatSDK.thread().getThreads(ThreadType.Public)){
            ChatRoom chatRoom = new ChatRoom(thread);
            if( chatRoom.getSource().equals(source)
                    && chatRoom.getDestination().equals(destination)
                    && (chatRoom.getCapacity() - chatRoom.getSize()) > 0 ) {

                result.add(chatRoom);
            }
        }

        return result;
    }
}
