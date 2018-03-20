package com.example.ataufiq.intentline;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String PACKAGE_NAME_Line = "jp.naver.line.android";
    public static final String PACKAGE_NAME_WA = "com.whatsapp";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";

    private List<ApplicationInfo> m_appList;

    EditText mIdLine,mTemplateMessageLine,mNomor,mTemplateMessageWA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdLine = findViewById(R.id.et_id_line);
        mTemplateMessageLine =findViewById(R.id.et_template_message_line);
        mNomor= findViewById(R.id.et_nomor_handphone);
        mTemplateMessageWA = findViewById(R.id.et_template_message_wa);
    }

    //Button Add Friend
    public void addFriend(View view)  {
        if (checkLineInstalled()) {
            String userId = mIdLine.getText().toString();
            String url = "line://ti/p/~" + userId;
            Intent intent = null;
            try {
                intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            startActivity(intent);
        }else {
            Toast.makeText(this, "You don't have Line App", Toast.LENGTH_SHORT).show();
        }
    }

    //Button Template Message
    public void sendText(View view) {
        String message= mTemplateMessageLine.getText().toString();

        if (checkLineInstalled()){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setClassName(PACKAGE_NAME_Line, CLASS_NAME);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(intent);
        }else {
            Toast.makeText(this, "You Don't have Line App", Toast.LENGTH_SHORT).show();
        }


    }

    public void sendToWhatsapp(View view) {
        String nomor=mNomor.getText().toString();
        String text = mTemplateMessageWA.getText().toString();

        String[] kata = text.split("\\s+");
        String kalimat="";
        for (int i =0;i<kata.length;i++){
            kalimat+=kata[i]+"%20";
        }
        String url ="https://api.whatsapp.com/send?phone="+nomor+"&text="+kalimat;
        Log.d("Testing",kalimat);
        if (checkWAInstalled()){
            try {
            Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                startActivity(intent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }else {
            Toast.makeText(this, "You Don't have Whatsapp App", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean checkLineInstalled(){
        PackageManager pm = getPackageManager();
        m_appList = pm.getInstalledApplications(0);
        boolean lineInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_NAME_Line)){
                lineInstallFlag = true;
                break;
            }
        }
        return lineInstallFlag;
    }

    private boolean checkWAInstalled(){
        PackageManager pm = getPackageManager();
        m_appList = pm.getInstalledApplications(0);
        boolean WAInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_NAME_WA)){
                WAInstallFlag = true;
                break;
            }
        }
        return WAInstallFlag;
    }
}
