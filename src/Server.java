
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gabriel
 */
public class Server {
    public static List<ConectedClient> clientes;
    private int port;
    ServerSocket ss;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Server server = new Server(8088);
        server.aguardarClientes();
    }

    public Server(int port) {
        this.port = port;
        setup();
    }

    private void setup() {
        try {
            ss = new ServerSocket(port);
            clientes = new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void aguardarClientes() {
        Socket s;
        ConectedClient cli;
        try {
            while (true) {
                s = ss.accept();
                cli = new ConectedClient(s);
                clientes.add(cli);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
