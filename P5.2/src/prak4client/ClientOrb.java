package prak4client;

import prak4gemklassen.Benutzer;
import prak4gemklassen.BenutzerAlreadyExistsException;
import prak4gemklassen.BenutzerNotFoundException;
import prak4gemklassen.BenutzerVerwaltung;
import prak4serv.ServerOrb;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientOrb implements BenutzerVerwaltung {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private ServerOrb serverOrb;
    private int port = 88;
    private String address;

    public ClientOrb(String address)
    {
        this.address = address;
    }

    public void Connect()
    {
        try
        {
            socket = new Socket(address, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception e)
        {
            System.err.println("Error connecting: " + e.getMessage());
        }
    }

    public void Disconnect()
    {
        try
        {
            out.close();
            in.close();
            socket.close();
        }
        catch (Exception e)
        {
            System.err.println("Error disconnecting: " + e.getMessage());
        }
    }

    /*
    Client -> Server
    1 = dbInit
    2 = neuerBenutzer
    3 = benutzerOk
     */
    public boolean sendAndRead(int task, Object value)
    {
        boolean result = false;
        try {
            Connect();

            out.write(task);
            out.writeObject(value);
            out.flush();

            result = in.readBoolean();

        }
        catch (Exception e)
        {
            System.err.println("Error sending: " + e.getMessage());
        }
        Disconnect();

        return result;
    }

    public void send(int task)
    {
        try {
            Connect();

            out.write(task);
            out.flush();

        }
        catch (Exception e)
        {
            System.err.println("Error sending: " + e.getMessage());
        }
        Disconnect();
    }

    public void benutzerEintragen(Benutzer benutzer) throws BenutzerAlreadyExistsException
    {
        if (!sendAndRead(2, benutzer))
        {
            throw new BenutzerAlreadyExistsException("Benutzer existiert bereits!");
        }
    }

    public void dbInitialisieren()
    {
        send(1);
    }

    public boolean benutzerOk(Benutzer benutzer)
    {
        return sendAndRead(3, benutzer);
    }
}
