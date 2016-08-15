import java.net.*;
import java.io.*;
import java.io.IOException.*;
public class TestServer
{    public final static String
       FILE_TO_RECEIVED = "c:teh1.txt";  
    public final static int FILE_SIZE = 6022386; 
   
   public static void main(String args[]) throws IOException
   {  int bytesRead;
    int current = 0;
    FileOutputStream fos = null;
    BufferedOutputStream bos = null;
     ServerSocket server = null;
 
      try 
      {
         server = new ServerSocket(4000);
      } 
      catch (IOException e) 
      {
         System.out.println("Error on port: 4000 " + ", " + e);
         System.exit(1);
      }

      System.out.println("Server setup and waiting for client connection ...");

      Socket client = null;
      try 
      {
         client = server.accept();
    System.out.println("Accepted connection : " + client);
      } 
      catch (IOException e) 
      {
         System.out.println("Did not accept connection: " + e);
         System.exit(1);
      }

      System.out.println("Client connection accepted. Moving to local port ...");


        
     
   

 
try
{
// receive file
      byte [] mybytearray  = new byte [FILE_SIZE];
      InputStream is = client.getInputStream();
      fos = new FileOutputStream(FILE_TO_RECEIVED);
      bos = new BufferedOutputStream(fos);
      bytesRead = is.read(mybytearray,0,mybytearray.length);
      current = bytesRead;
     
       do {
         bytesRead =
            is.read(mybytearray, current, (mybytearray.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      bos.write(mybytearray, 0 , current);
      bos.flush();
      System.out.println("File " + FILE_TO_RECEIVED
          + " downloaded (" + current + " bytes read)");
    }

catch(FileNotFoundException fe)
{
System.out.println(fe);
         System.exit(1);
}
catch (IOException e) 
      {
         System.out.println("Error on port: 4000 " + ", " + e);
         System.exit(1);
      }

    finally {
      if (fos != null) fos.close();
      if (bos != null) bos.close();
      if (server != null) server.close();
    }
  }



}


