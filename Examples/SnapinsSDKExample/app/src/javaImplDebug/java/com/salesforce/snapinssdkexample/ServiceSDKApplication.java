package com.salesforce.snapinssdkexample;

import android.app.Activity;
import android.app.Application;

import com.salesforce.android.chat.core.internal.liveagent.ChatStateListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.snapinssdkexample.activities.MainActivity;

public class ServiceSDKApplication extends Application {
    private ChatSessionListener chatSessionListener;

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Salesforce Mobile SDK for authentication
        initializeSalesforceSDKManager(MainActivity.class);

        ServiceLogging.addSink(ServiceLogging.LOG_CAT_SINK);
        ServiceLogging.setLogLevel(ServiceLogging.LEVEL_TRACE);

        chatSessionListener = new ChatSessionListener(getApplicationContext());
    }

    private void initializeSalesforceSDKManager (Class<? extends Activity> activity){
        SalesforceSDKManager.initNative(this, null, activity);
    }

    public ChatSessionListener getChatSessionListener() {
        return chatSessionListener;
    }
}
