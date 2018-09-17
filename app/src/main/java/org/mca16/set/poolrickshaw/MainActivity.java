package org.mca16.set.poolrickshaw;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.facebook.internal.Logger;

import co.chatsdk.core.dao.Message;
import co.chatsdk.core.dao.Thread;
import co.chatsdk.core.error.ChatSDKException;
import co.chatsdk.core.handlers.VideoMessageHandler;
import co.chatsdk.core.session.ChatSDK;
import co.chatsdk.core.session.Configuration;
import co.chatsdk.core.session.InterfaceManager;
import co.chatsdk.core.session.NetworkManager;
import co.chatsdk.core.types.MessageSendProgress;
import co.chatsdk.firebase.FirebaseNetworkAdapter;
import co.chatsdk.firebase.file_storage.FirebaseFileStorageModule;
import co.chatsdk.firebase.push.FirebasePushModule;
import co.chatsdk.firebase.social_login.FirebaseSocialLoginModule;
import co.chatsdk.ui.chat.options.MediaChatOption;
import co.chatsdk.ui.manager.BaseInterfaceAdapter;
import io.reactivex.Observable;

import static com.facebook.FacebookSdk.getApplicationContext;

public class MainActivity extends MultiDexApplication {



    public void onCreate() {
        super.onCreate();

        Context context = getApplicationContext();

        Log.d("TAG", "----------------App Started------------------");
        Configuration.Builder config = new Configuration.Builder(context);
//        builder.firebaseRootPath("firebase_v4_web_new_4");
        config.firebaseRootPath("prod");
//        config.firebaseCloudMessagingServerKey("AAAALDyASfE:APA91bFbxQiL3Y6yT1jNgfjglpXOpLjWa7kv2k-_Pt9JoKZ_WHx8MBtCGFJgqUofJnYRoxvqUaC3TATYdqeDhLoylSsH2Esquy3VuCOqbNHehuUdMu7l2NDMiEZGGLrCCozANzOdzk64");
        config.publicRoomCreationEnabled(true);

        config.pushNotificationSound("default");
        config.facebookLoginEnabled(false);
        config.twitterLoginEnabled(false);
        config.googleLoginEnabled(true);
        config.locationMessagesEnabled(false);
        try {
            ChatSDK.initialize(config.build(), new PoolRickshawBaseInterfaceAdapter(context), new FirebaseNetworkAdapter());
        } catch (ChatSDKException e) {

        }

        FirebaseFileStorageModule.activate();
        FirebasePushModule.activateForFirebase();
//      FirebaseUIModule.activate(context, EmailAuthProvider.PROVIDER_ID, PhoneAuthProvider.PROVIDER_ID);
    }

    @Override
    protected void attachBaseContext (Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}