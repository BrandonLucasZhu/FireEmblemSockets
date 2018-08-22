package ee.brandonzhu.contactmsgsender;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {

    public static final String SERVER_IP = "192.168.1.8"; //server IP address
    public static final int SERVER_PORT = 1234;
    // message to send to the server
    private String mServerMessage;
    // while this is true, the server will continue running
    private boolean mRun = false;

    private BufferedReader input;
    private BufferedReader fromServer;
    // used to send messages
    private PrintWriter toServer;

    private String clientName;



    public TcpClient(String clientName) {
        this.clientName = clientName;
        Socket socket = new Socket(SERVER_IP, SERVER_PORT);
        input = new BufferedReader(new InputStreamReader(System.in));
        toServer = new PrintWriter(socket.getOutputStream(),true);
        fromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void sendReceiveMSG() {
        toServer.print(clientName);  //send the request to the server
        toServer.flush();
        fromServer.read(); //read results from sent request to the server
    }



}
