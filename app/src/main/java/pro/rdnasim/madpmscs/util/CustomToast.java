package pro.rdnasim.madpmscs.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import pro.rdnasim.madpmscs.R;

public class CustomToast extends Toast {
    private Context context;
    private String message;
    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     * @param message
     */
    public CustomToast(Context context, String message) {
        super(context);
        this.context = context;
        this.message = this.message;
        View view = LayoutInflater.from(context).inflate(R.layout.activity_custom_toast, null);
        TextView txtMsg = view.findViewById(R.id.txt_message);
        txtMsg.setText(message);
        setView(view);
        setDuration(Toast.LENGTH_LONG);
    }
}
