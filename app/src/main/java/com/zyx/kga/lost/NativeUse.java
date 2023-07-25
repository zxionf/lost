package com.zyx.kga.lost;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.zyx.kga.lost.Info;
import java.util.ArrayList;
import java.util.List;
import android.widget.EditText;
import android.os.Looper;

public class NativeUse {
	Context _context;
	Handler hd;
    Activity activityhandler;
	public NativeUse(Context context, Activity a) {
		_context = context;
		hd = new Handler();
        activityhandler = a;
	}
    
    public void EditDialog(){
        hd.post(new Runnable(){

                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(_context);
                    builder.setTitle("请输入");    //设置对话框标题
                    //builder.setIcon(android.R.drawable.btn_star);   //设置对话框标题前的图标
                    final EditText edit = new EditText(_context);
                    builder.setView(edit);
                    builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(_context, "你输入的是: " + edit.getText().toString(), Toast.LENGTH_SHORT).show();
                                Info.playerName = edit.getText().toString();
                            }
                        });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(_context, "你点了取消", Toast.LENGTH_SHORT).show();
                            }
                        });
                    builder.setCancelable(true);    //设置按钮是否可以按返回键取消,false则不可以取消
                    AlertDialog dialog = builder.create();  //创建对话框
                    dialog.setCanceledOnTouchOutside(true); //设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏
                    dialog.show();
                }
                
            
        });
        
    }

    public void getversion() {
        //获取游戏信息//Looper.loop();
        PackageManager  packagemanager =_context.getPackageManager();
        PackageInfo packinfo = null;
        try {
            packinfo = packagemanager.getPackageInfo(_context.getPackageName(), 0);
        } catch (Exception e) {}
        Info.versionCode = packinfo.versionCode;
        Info.versionName = packinfo.versionName;

    }

	public boolean isNetEnable() {
		// TODO Auto-generated method stub
		ConnectivityManager connectivityManager = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivityManager == null) {
			return false;
		} else {
			NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();

			if (networkInfo != null && networkInfo.length > 0) {
				for (int i = 0; i < networkInfo.length; i++) {
					System.out.println(i + "==net state==" + networkInfo[i].getState());
					System.out.println(i + "===net type===" + networkInfo[i].getTypeName());
					if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}


	public void showQuickTip(final String context) {
		// TODO Auto-generated method stub
		hd.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Toast.makeText(_context, context, Toast.LENGTH_SHORT).show();
				}
			});


	}

	public BitmapFont getFont(String characters) {
		// TODO Auto-generated method stub
		return null;
	}

	public void callPay(final String payee, final int money) {
		// TODO Auto-generated method stub
		hd.post(new Runnable() {
				public void run() {
					Intent intent=new Intent(_context, MainActivity.class);

					Bundle bundle=new Bundle();
					bundle.putString("payee", payee);
					bundle.putInt("money", money);

					intent.putExtras(bundle);
					_context.startActivity(intent);
				}
			});




	}

	public void showQucikDialog(final String title, final String context, final Runnable callback) {
		// TODO Auto-generated method stub
		hd.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					new  AlertDialog.Builder(_context)    
						.setTitle(title)  
						.setMessage(context)  
						.setPositiveButton("确定" , new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Gdx.app.postRunnable(callback);

							}
						})  
						.show();
				}
			});

	}

	public void showDialog(final String title, final String context, final Runnable ok, final Runnable cancel) {
		hd.post(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					new  AlertDialog.Builder(_context)    
						.setTitle(title)  
						.setMessage(context)
						.setNegativeButton("取消", new OnClickListener(){
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Gdx.app.postRunnable(cancel);

							}
						})
						.setPositiveButton("确定" , new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								Gdx.app.postRunnable(ok);

							}
						})  
						.show();
				}
			});

	}

    // 请求多个权限
    public void request_permissions() {
        // 创建一个权限列表，把需要使用而没用授权的的权限存放在这里
        List<String> permissionList = new ArrayList<>();

        // 判断权限是否已经授予，没有就把该权限添加到列表中
        if (ContextCompat.checkSelfPermission(_context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        if (ContextCompat.checkSelfPermission(_context, Manifest.permission.READ_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        /*if (ContextCompat.checkSelfPermission(_context, Manifest.permission.READ_PHONE_STATE)
         != PackageManager.PERMISSION_GRANTED) {
         permissionList.add(Manifest.permission.READ_PHONE_STATE);
         }*/
        // 如果列表为空，就是全部权限都获取了，不用再次获取了。不为空就去申请权限
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(activityhandler,
                                              permissionList.toArray(new String[permissionList.size()]), 1002);

            //Toast.makeText(getApplication(), "无法存储游戏数据，重启应用重新授权", Toast.LENGTH_SHORT).show();

        } else {
            //Toast.makeText(this, "多个权限你都有了，不用再次申请", Toast.LENGTH_LONG).show();

        }
    }

    public String getDeviceinfo() {
        //TelephonyManager tm = (TelephonyManager) _context.getSystemService(Service.TELEPHONY_SERVICE);

        String android_id = Settings.System.getString(_context.getContentResolver(), Settings.Secure.ANDROID_ID);
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                //return tm.getImei()+"/"+Build.getSerial();
                return Build.getSerial()+"/"+android_id;
            } else {
                //return tm.getDeviceId()+"/"+Build.SERIAL;
                return Build.SERIAL+"/"+android_id;
            }
        } catch (Exception e) {
            return android_id;
        }
        //return Settings.System.getString(_context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

}

