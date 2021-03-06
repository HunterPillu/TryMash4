package com.studio.trymash.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.studio.trymash.R;
import com.studio.trymash.helper.Mydb;
import com.studio.trymash.utils.Constant;

public class HighScoreActivity extends AppCompatActivity {
    static TableLayout tl = null;
    static TextView tv1 = null;
    static TextView tv2 = null;
    static ImageView iv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);
        tl = (TableLayout) findViewById(R.id.tl);
        iv = (ImageView) findViewById(R.id.iv);
        Mydb md = Mydb.getDB(this);
        SQLiteDatabase sqlte = md.getWritableDatabase();
        Cursor cu = sqlte.rawQuery(Constant.SELECT_ALL_DATA_QUERY, null);

        while (cu.moveToNext()) {
            //tv.setText(cu.getString(1));
            //Log.i("score is ",cu.getString(2));
            TableRow tr = new TableRow(this);
            tl.addView(tr);
            tv1 = new TextView(this);
            tv1.setText(cu.getString(1));
            tv2 = new TextView(this);
            tv2.setText(cu.getString(2));
            tr.addView(tv1);
            tr.addView(tv2);
        }
        iv.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent ine = new Intent(getApplicationContext(), FirstActivity.class);
                startActivity(ine);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.high_score, menu);
        return true;
    }

}
