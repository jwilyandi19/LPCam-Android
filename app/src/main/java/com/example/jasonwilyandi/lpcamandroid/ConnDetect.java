package lp.lpcamera;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

/**
 * Created by GambleR on 10/29/2017.
 */

public class ConnDetect {
    private Context _context;
    public ConnDetect(Context context){
        this._context = context;
    }
    public boolean isConnect(){
        ConnectivityManager connectivity=(ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity!=null){
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if(info != null){
                for (int i=0;i<info.length;i++){
                    if(info[i].getState()== NetworkInfo.State.CONNECTED) return true;
                }
            }
        }
        return false;
    }
    @SuppressWarnings("deprecation")
    public void showAlertDialog(Context context, String title, String msg, Boolean status){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title); // set dialog title
        alertDialog.setMessage(msg); // set dialog msg
        // set tombol ok
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        alertDialog.show();
    }
}