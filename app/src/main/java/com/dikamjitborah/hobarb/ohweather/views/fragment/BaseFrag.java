package com.dikamjitborah.hobarb.ohweather.views.fragment;

import android.app.Dialog;
import android.view.Window;
import android.widget.ProgressBar;

import com.dikamjitborah.hobarb.ohweather.R;

import androidx.fragment.app.Fragment;

public class BaseFrag extends Fragment {

    Dialog dialog;
    public void showProgressBar(){
        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.progressbar_dialog);

        ProgressBar progressBar = dialog.findViewById(R.id.progress_pb_dialog);
        dialog.setCancelable(false);
        dialog.show();


    }

    public void hideProgressBar(){
        if(dialog!=null &&dialog.isShowing())
        {
            dialog.dismiss();
            dialog = null;
        }

    }
}
