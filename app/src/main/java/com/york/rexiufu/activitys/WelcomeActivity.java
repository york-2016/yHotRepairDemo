package com.york.rexiufu.activitys;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;

import com.york.rexiufu.R;
import com.york.rexiufu.rexiufu.FixDexUtil;
import com.york.rexiufu.utils.PermissionUtil;

import java.io.File;

public class WelcomeActivity extends Activity {
    private String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE};
    private PermissionUtil.IPermissionsResult mIPermissionsResult = new PermissionUtil.IPermissionsResult() {
        @Override
        public void passPermissons() {

        }

        @Override
        public void forbitPermissons() {

        }
    };
    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionUtil.getInstance().onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        PermissionUtil.getInstance().chekPermissions(this, permissions, mIPermissionsResult);
        init();
    }

    private void init() {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        // 遍历所有的修复dex , 因为可能是多个dex修复包
        File fileDir = externalStorageDirectory != null ? new File(externalStorageDirectory,"YorkFix"): new File(getFilesDir(), FixDexUtil.DEX_DIR);// data/user/0/包名/files/odex（这个可以任意位置）
        if (!fileDir.exists()){
            fileDir.mkdirs();
        }
        if (FixDexUtil.isGoingToFix(this)) {
            FixDexUtil.loadFixedDex(this, Environment.getExternalStorageDirectory());
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
            }
        },3000);

    }
}
