package com.ycc.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ClickableSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.ms.square.android.expandabletextview.TextViewFixTouchConsume;

public class MainActivity extends AppCompatActivity {
    TextViewFixTouchConsume tv;
    RelativeLayout rl;
    ExpandableTextView edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rl = (RelativeLayout) findViewById(R.id.rl);
        edt = (ExpandableTextView) findViewById(R.id.expand_text_view);
        tv = (TextViewFixTouchConsume) findViewById(R.id.expandable_text);
        
        tv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Textview on  long click", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
        edt.setText("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        tv.setMovementMethod(TextViewFixTouchConsume.LocalLinkMovementMethod.getInstance());
        SpannableString spannableString=new SpannableString(edt.getText());
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this, "span", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setColor(Color.BLUE);
                super.updateDrawState(ds);
            }
        },1,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        edt.setText(spannableString);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "rl on click", Toast.LENGTH_SHORT).show();
            }
        });



    }


}
