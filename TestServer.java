import java.net.*;
import java.io.*;

public class TestServer
{
   public static void main(String args[])
   {
      ServerSocket server = null;
      public final static String FILE_TO_SEND = "D:/abc.txt";
      try 
      {
        
         FileInputStream fis = null;
         BufferedInputStream bis = null;  
         OutputStream os = null;

      } 
      catch (IOException e) 
      {
         System.out.println("Error on port: 4000" + ", " + e);
         System.exit(1);
      }

      System.out.println("Server setup and waiting for client connection ...");

      Socket client = null;
  try
    {
      server = new ServerSocket(4000); 
      while(true)
       {
         System.out.println("waiting......")
      try 
      {
         client = server.accept(); 
          File myFile = new File (FILE_TO_SEND);
          byte [] mybytearray  = new byte [(int)myFile.length()];
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          bis.read(mybytearray,0,mybytearray.length);
          os = sock.getOutputStream();
          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
          os.write(mybytearray,0,mybytearray.length);
          os.flush();
          System.out.println("Done.");

      } 
finally {
          if (bis != null) bis.close();
          if (os != null) os.close();
          if (sock!=null) sock.close();
        }
      }
    }
    finally {
      if (servsock != null) servsock.close();
    }
  }
}


      catch (IOException e) 
      {
         System.out.println("Did not accept connection: " + e);
         System.exit(1);
      }

      System.out.println("Client connection accepted. Moving to local port ...");

      try
      {
         DataInputStream streamIn = new 
                  DataInputStream(new 
                  BufferedInputStream(client.getInputStream()));

         boolean done = false;
         String line;
         while (!done)
         {
            line = streamIn.readLine();
            if (line.equalsIgnoreCase(".bye"))
               done = true;
            else
               System.out.println("Client says: " + line);
         }

         streamIn.close();
         client.close();
         server.close();
      }
      catch(IOException e)
      { System.out.println("IO Error in streams " + e); }
   }
}
 