package ServerUI;

import Models.Gameboard;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static Gameboard gameboard;
    private List<Socket> Connections = new ArrayList<Socket>();
    public static void main(String[] args) throws Exception
    {
        try
        {
            Main.gameboard = new Gameboard();
            System.out.println("Server started");
            final int PORT = 34652;
            System.out.println("The game server is running and waiting for clients.");
            ServerSocket listener = new ServerSocket(PORT);

            
        }
        catch (Exception ex)
        {
            System.out.print(ex.getMessage());
        }
    }
}
