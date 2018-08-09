package ee.brandonzhu.contactmsgsender;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button msgServer = (Button) findViewById(R.id.sendMSG);

        msgServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                client = new Socket();
                client.connect(
                        new InetSocketAddress(
                                "IP-ADDRESS",
                                ),
                        5000);
                in = new BufferedReader(
                        new InputStreamReader(
                                client.getInputStream()));
                printlng = new PrintWriter(
                        client.getOutputStream());
                printlng.println(mLongitude);
                printlng.flush();

                try {
                    if ((Response = in
                            .readLine()) != null) {
            }
        });


    }
}
