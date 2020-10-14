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

    ImageButton aboutBtn1, aboutBtn2, aboutBtn3;
    Dialog aboutDialog;
    TextView popupName, popupDescription;
    ImageView popupImage, popupClose, popupLinkedin, popupGithub, popupTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        aboutDialog =new Dialog(this);
        aboutBtn1 = findViewById(R.id.btn_about1);
        aboutBtn2 = findViewById(R.id.btn_about2);
        aboutBtn3 = findViewById(R.id.btn_about3);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_about);
        setSupportActionBar(toolbar);

        //Add back button and name to Appbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About");
        actionBar.setDisplayHomeAsUpEnabled(true);

        aboutBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout1Popup();
            }
        });
        aboutBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout2Popup();
            }
        });
        aboutBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAbout3Popup();
            }
        });

    }

    private void showAbout1Popup() {
        aboutDialog.setContentView(R.layout.popup_about);

        popupClose = aboutDialog.findViewById(R.id.popup_close);
        popupImage = aboutDialog.findViewById(R.id.popup_image);

        popupName = aboutDialog.findViewById(R.id.popup_name);
        popupDescription = aboutDialog.findViewById(R.id.popup_description);

        popupLinkedin = aboutDialog.findViewById(R.id.popup_linkedin);
        popupGithub = aboutDialog.findViewById(R.id.popup_github);
        popupTwitter = aboutDialog.findViewById(R.id.popup_twitter);

        popupImage.setImageResource(R.drawable.aditya);
        popupName.setText(R.string.AboutDeveloper1);
        popupDescription.setText(R.string.ece_iiit_surat);

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
                intent.setData(Uri.parse("https://www.linkedin.com/in/iam844"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/iam844"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/adityajaiswal84"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aboutDialog.show();
    }
    private void showAbout2Popup() {
        aboutDialog.setContentView(R.layout.popup_about);
        popupClose = aboutDialog.findViewById(R.id.popup_close);
        popupImage = aboutDialog.findViewById(R.id.popup_image);

        popupName = aboutDialog.findViewById(R.id.popup_name);
        popupDescription = aboutDialog.findViewById(R.id.popup_description);

        popupLinkedin = aboutDialog.findViewById(R.id.popup_linkedin);
        popupGithub = aboutDialog.findViewById(R.id.popup_github);
        popupTwitter = aboutDialog.findViewById(R.id.popup_twitter);

        popupImage.setImageResource(R.drawable.aakash);
        popupName.setText(R.string.AboutDeveloper2);
        popupDescription.setText(R.string.cse_iiit_surat);

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
                intent.setData(Uri.parse("https://www.linkedin.com/in/aakash-gavle-a90158190/"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/aakash-gavle"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/Aakash_gavle"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aboutDialog.show();
    }
    private void showAbout3Popup() {
        aboutDialog.setContentView(R.layout.popup_about);
        popupClose = aboutDialog.findViewById(R.id.popup_close);
        popupImage = aboutDialog.findViewById(R.id.popup_image);

        popupName = aboutDialog.findViewById(R.id.popup_name);
        popupDescription = aboutDialog.findViewById(R.id.popup_description);

        popupLinkedin = aboutDialog.findViewById(R.id.popup_linkedin);
        popupGithub = aboutDialog.findViewById(R.id.popup_github);
        popupTwitter = aboutDialog.findViewById(R.id.popup_twitter);

        popupImage.setImageResource(R.drawable.krishna);
        popupName.setText(R.string.AboutDesigner);
        popupDescription.setText(R.string.ece_iiit_surat);

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
                intent.setData(Uri.parse("https://www.linkedin.com/in/krishnaojha02"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupGithub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/coder-KO"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        popupTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://twitter.com/KrishnaOjha02"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        aboutDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        aboutDialog.show();
    }

}
