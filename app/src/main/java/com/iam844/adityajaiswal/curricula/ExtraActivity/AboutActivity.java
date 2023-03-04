package com.iam844.adityajaiswal.curricula.ExtraActivity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.iam844.adityajaiswal.curricula.R;

public class AboutActivity extends AppCompatActivity {

    ImageButton aboutBtn1, aboutBtn2, aboutBtn3, aboutBtn4;
    Dialog aboutDialog;
    TextView popupName, popupDescription;
    ImageView popupImage, popupClose, popupLinkedin, popupGithub, popupTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutDialog = new Dialog(this);
        aboutBtn1 = findViewById(R.id.btn_about1);
        aboutBtn2 = findViewById(R.id.btn_about2);
        aboutBtn3 = findViewById(R.id.btn_about3);
        aboutBtn4 = findViewById(R.id.btn_about4);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About");
        actionBar.setDisplayHomeAsUpEnabled(true);
        setPopup();

        aboutBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutPopup(R.drawable.aditya, R.string.AboutDeveloper1,
                        R.string.ece_iiit_surat, "https://www.linkedin.com/in/iam844",
                        "https://github.com/iam844", "https://twitter.com/adityajaiswal84");
            }
        });
        aboutBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutPopup(R.drawable.aakash, R.string.AboutDeveloper2, R.string.cse_iiit_surat,
                        "https://www.linkedin.com/in/aakash-gavle-a90158190/",
                        "https://github.com/aakash-gavle", "https://twitter.com/Aakash_gavle");
            }
        });
        aboutBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAboutPopup(R.drawable.krishna, R.string.AboutDesigner, R.string.ece_iiit_surat,
                        "https://www.linkedin.com/in/krishnaojha02",
                        "https://github.com/coder-KO",
                        "https://twitter.com/KrishnaOjha02"
                );
            }
        });
        aboutBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAboutPopup(R.drawable.suraj, R.string.AboutMaintainer, R.string.ece_iiit_surat,
                        "https://www.linkedin.com/in/ss26/",
                        "https://github.com/surajsisodia",
                        "https://twitter.com/marcos_suraj");
            }
        });

    }

    private void setPopup() {
        aboutDialog.setContentView(R.layout.popup_about);
        popupClose = aboutDialog.findViewById(R.id.popup_close);
        popupImage = aboutDialog.findViewById(R.id.popup_image);

        popupName = aboutDialog.findViewById(R.id.popup_name);
        popupDescription = aboutDialog.findViewById(R.id.popup_description);

        popupLinkedin = aboutDialog.findViewById(R.id.popup_linkedin);
        popupGithub = aboutDialog.findViewById(R.id.popup_github);
        popupTwitter = aboutDialog.findViewById(R.id.popup_twitter);
    }

    private void showAboutPopup(int image, int name, int branch, String linkedIn, String github, String twitter) {

        popupImage.setImageResource(image);
        popupName.setText(name);
        popupDescription.setText(branch);

        popupClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutDialog.dismiss();
            }
        });

        popupLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(linkedIn));
//                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
//                }
            }
        });

        popupGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(github));
//                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
//                }
            }
        });

        popupTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(twitter));
//                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
//                }
            }
        });

        aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aboutDialog.show();
    }
}
