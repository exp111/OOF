package prak4serv;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerAlreadyExistsException;
import prak4gemklassen.BenutzerVerwaltungAdmin;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOrb {
    private ServerSocket serverSocket;
    private BenutzerVerwaltungAdmin bv;

    public ServerOrb(BenutzerVerwaltungAdmin bv)
    {
        this.bv = bv;
        try {
            serverSocket = new ServerSocket(88);
        }
        catch (Exception e)
        {
            System.err.println("Error while creating Server Socket: " + e.getMessage());
            e.printStackTrace();
        }

        while (true)
        {
            try
            {
                Socket client = serverSocket.accept();
                ObjectInputStream in    =  new ObjectInputStream(client.getInputStream());
                ObjectOutputStream out  =  new ObjectOutputStream(client.getOutputStream());

                int task = in.read();

                switch (task)
                {
                    case 1: //1 = dbInit
                        System.out.println("Initializing");
                        bv.dbInitialisieren();

                        break;
                    case 2: // 2 = neuerBenutzer
                    {
                        System.out.println("New User:");
                        Benutzer b = (Benutzer) in.readObject();
                        System.out.println(b.toString());
                        boolean result = true;
                        try {
                            bv.benutzerEintragen(b);
                        }
                        catch (BenutzerAlreadyExistsException e)
                        {
                            result = false;
                        }
                        out.writeBoolean(result);
                        out.flush();
                        break;
                    }
                    case 3: // 3 = benutzerOk
                    {
                        System.out.println("Chceking User:");
                        Benutzer b = (Benutzer) in.readObject();
                        System.out.println(b.toString());
                        out.writeBoolean(bv.benutzerOk(b));
                        out.flush();
                        break;
                    }
                }
            }
            catch (Exception e)
            {
                System.err.println("Error while running: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
