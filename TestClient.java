import java.io.*;
import java.net.*;

public class TestClient 
{
    public final static String FILE_TO_SEND = "c:teh.txt"; 
   public static void main(String[] args) throws IOException
   {
      String host = "localhost";
     
         FileInputStream fis = null;
  	 BufferedInputStream bis = null;
 	 OutputStream os = null;
   	 ServerSocket server = null;
 	Socket client =null;
  	
try
{
         client = new Socket(host, 4000);}
        
      catch (UnknownHostException he) 
      { System.out.println(host + ": unknown host."); } 

      catch (IOException e) 
      { System.err.println("I/O error with " + host); }
try{
     
      while (true) {
        System.out.println("Waiting...");
      
          System.out.println("Connected to " + host);
        
          // send file
          File myFile = new File (FILE_TO_SEND);
          byte [] mybytearray  = new byte [(int)myFile.length()];
  os = client.getOutputStream();
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          int trbyte=0;
         while((trbyte=bis.read(mybytearray,0,mybytearray.length))!=-1)
        {

          System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
          os.write(mybytearray,0,mybytearray.length);
	
         } os.flush();

          bis.close();
      client.close();

             System.out.println("file transferred...");

          System.out.println("Done.");
              }
}
     
   catch(Exception e)
    {
        System.out.println("Client Exception : "+e.getMessage());
    }       
    
    
 
   }
}