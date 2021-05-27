package sg.edu.rp.c346.id20031826.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //create variables
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find
        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);
        //register
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v == tvDBS) {
            wordClicked = "first";
        } else if (v == tvOCBC) {
            wordClicked = "second";
        } else if (v == tvUOB) {
            wordClicked = "third";
        }

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("first")) {
            if(item.getItemId() == 0) {
                //link to DBS website
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                //sent to contact with number already in DBS
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800" + 1111111));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("second")) {
            if(item.getItemId() == 0) {
                //link to OCBC website
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                //sent to contact with number already in OCBC
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel: 1800" + 3633333));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("third")) {
            if(item.getItemId() == 0) {
                //link to UOB
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == 1) {
                //sent to contact with num already in UOB
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: 1800" + 2222121));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}