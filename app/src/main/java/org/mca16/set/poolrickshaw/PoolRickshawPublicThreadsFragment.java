package org.mca16.set.poolrickshaw;

import android.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.handlers.ThreadHandler;
import co.chatsdk.core.interfaces.ThreadType;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.ui.threads.PublicThreadsFragment;
import co.chatsdk.ui.utils.ToastHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class PoolRickshawPublicThreadsFragment extends PublicThreadsFragment {
    @Override
    protected List<Thread> getThreads() {
//        ThreadHandler handler = ChatSDK.thread();
//
//        List<Thread> threads = new ArrayList<>();
//
//        for( Thread thread : ChatSDK.thread().getThreads(ThreadType.Public) ){
//            if( thread.getUsers().contains(ChatSDK.currentUser()) ){
//                threads.add(thread);
//            }
//        }
//        return threads;
////
        return ChatSDK.thread().getThreads(ThreadType.Public);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        /* Cant use switch in the library*/
        int id = item.getItemId();

        if (id == co.chatsdk.ui.R.id.action_chat_sdk_add)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
            builder.setTitle(getString(co.chatsdk.ui.R.string.add_public_chat_dialog_title));

            // Set up view
            LayoutInflater inflater = getLayoutInflater();
            View dialoglayout = inflater.inflate(R.layout.create_chat_room_dialog, null);
            builder.setView(dialoglayout);

            // Wiring view with objects
            EditText titleEditText = dialoglayout.findViewById(R.id.dialog_create_chat_room_title);
            EditText sourceEditText = dialoglayout.findViewById(R.id.dialog_create_chat_room_source);
            EditText destinationEditText = dialoglayout.findViewById(R.id.dialog_create_chat_room_destination);
            EditText capacityEditText = dialoglayout.findViewById(R.id.dialog_create_chat_room_capacity);

            // Set up the buttons
            builder.setPositiveButton(getString(co.chatsdk.ui.R.string.create), (dialog, which) -> {

                showOrUpdateProgressDialog(getString(co.chatsdk.ui.R.string.add_public_chat_dialog_progress_message));
                final String threadName = titleEditText.getText().toString();
                final String sourceStation = sourceEditText.getText().toString();
                final String destinationStation = destinationEditText.getText().toString();
                final int capacity = Integer.parseInt(capacityEditText.getText().toString());

                ChatSDK.publicThread().createPublicThreadWithName(threadName)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((thread, throwable) -> {
                            if (throwable == null) {
                                dismissProgressDialog();
                                adapter.addRow(thread);

                                ChatRoom chatRoom = new ChatRoom(thread);
                                chatRoom.setSource(sourceStation);
                                chatRoom.setDestination(destinationStation);
                                chatRoom.setCapacity(capacity);

                                ToastHelper.show(getContext(), String.format(getString(co.chatsdk.ui.R.string.public_thread__is_created), threadName));

                                ChatSDK.ui().startChatActivityForID(getContext(), thread.getEntityID());
                            }
                            else {
                                ChatSDK.logError(throwable);
                                Toast.makeText(this.getContext(), throwable.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                dismissProgressDialog();                            }
                        });

            });
            builder.setNegativeButton(co.chatsdk.ui.R.string.cancel, (dialog, which) -> dialog.cancel());

            builder.show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
