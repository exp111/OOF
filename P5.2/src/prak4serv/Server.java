package prak4serv;

import java.net.ServerSocket;

public class Server {
    private ServerOrb serverOrb;
    private BenutzerVerwaltungAdmin bv;

    public Server()
    {
        bv = new BenutzerVerwaltungAdmin();
        serverOrb = new ServerOrb(bv);
    }

    public static void main(String[] args) {
        Server server = new Server();
    }
}
