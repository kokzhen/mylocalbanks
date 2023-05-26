package sg.edu.rp.c346.id22014093.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button dbs;
    Button ocbc;
    Button uob;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.DBS);
        ocbc = findViewById(R.id.OCBC);
        uob = findViewById(R.id.UOB);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        wordClicked = "";

        if (v == dbs) {
            wordClicked = "DBS";
        } else if (v == ocbc) {
            wordClicked = "OCBC";
        } else if (v == uob) {
            wordClicked = "UOB";
        }

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equals("DBS")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.dbs.com.sg";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting DBS", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("OCBC")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.ocbc.com";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting OCBC", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("UOB")) {
            if (item.getItemId() == 0) { // Website
                String websiteUrl = "https://www.uob.com.sg";
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse(websiteUrl));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) { // Contact the bank
                Toast.makeText(MainActivity.this, "Contacting UOB", Toast.LENGTH_SHORT).show();
                Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;
            }
        }

        return super.onContextItemSelected(item);
    }
}

