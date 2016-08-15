import java.net.*;
import java.io.*;
import java.io.IOException.*;
public class mydes2
{    public final static String
       FILE_TO_RECEIVED = "c:teh1.txt";  

public final static String FILE_TO_SEND = "c:teh1.txt"; 
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
      byte [] textEncrypted  = new byte [FILE_SIZE];
      InputStream is = client.getInputStream();
      fos = new FileOutputStream(FILE_TO_RECEIVED);
      bos = new BufferedOutputStream(fos);
      bytesRead = is.read(textEncrypted,0,textEncrypted.length);
      current = bytesRead  ;
     
       do {
         bytesRead =
            is.read(textEncrypted,current,(textEncrypted.length-current));
         if(bytesRead >= 0) current += bytesRead;
      } while(bytesRead > -1);

      bos.write(textEncrypted, 0 , current);
      bos.flush();
      System.out.println("File " + FILE_TO_RECEIVED
          + " downloaded (" + current + " bytesread)");

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



//-----------------------------------------------------------------------------------------
/*

String host = "localhost";
     
         FileInputStream fis = null;
  	 BufferedInputStream bis = null;
 	 OutputStream os = null;
   	
      try 
      {
         server = new ServerSocket(4000);
      } 
      catch (IOException e) 
      {
         System.out.println("Error on port: 4000 " + ", " + e);
         System.exit(1);
      }

     try
{   	    File myFile = new File (FILE_TO_SEND);
          byte [] mybytearray  = new byte [(int)myFile.length()];
      
          os = client.getOutputStream();
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          int trbyte=0;
         while((trbyte=bis.read(mybytearray,0,mybytearray.length))!=-1)
        {
           

                      
          System.out.println("Text [Byte Format] : "+mybytearray);
                  
           

		    System.out.println("Text : "+new String(mybytearray));


                
           
                


  
          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
          os.write(mybytearray,0,mybytearray.length);

		   
	
         } os.flush();

          bis.close();
     server.close();

             System.out.println("file transferred...");

          System.out.println("Done.");
}


     
   catch(Exception e)
    {
        System.out.println("Client Exception : "+e.getMessage());
    }       
    						
*/
		
  }



}


