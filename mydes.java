
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.*;

public class mydes
{
 private byte[] encrypted;

    private String encryptedtext;
    private String decrypted;

		  
public final static String FILE_TO_SEND = "c:teh.txt"; 
public final static String FILE_TO_RECEIVE = "c:teh2.txt"; 
  	
	public static void main(String[] args) {


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

      
try{
     
      while (true) {
        System.out.println("Waiting...");
      
          System.out.println("Connected to " + host);
        
          // send file
          File myFile = new File (FILE_TO_SEND);
          byte [] mybytearray  = new byte [(int)myFile.length()];
            byte [] textEncrypted =new byte[(int)myFile.length()];
  os = client.getOutputStream();
          fis = new FileInputStream(myFile);
          bis = new BufferedInputStream(fis);
          int trbyte=0;
         while((trbyte=bis.read(mybytearray,0,mybytearray.length))!=-1)
        {
            try{ KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    SecretKey myDesKey = keygenerator.generateKey();

		    Cipher desCipher;

		    // Create the cipher
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

                      
          System.out.println("Text [Byte Format] : "+mybytearray);
                  
           

		    System.out.println("Text : "+new String(mybytearray));

                        System.out.println("Text Encryted len"+ textEncrypted.length);  
		    // Encrypt the text

                
		   textEncrypted = desCipher.doFinal(mybytearray);
           
                

		    System.out.println("Text Encryted : " + new String(textEncrypted));
 // Initialize the same cipher for decryption
		 //desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		    // Decrypt the text
		   // byte[] textDecrypted = desCipher.doFinal(textEncrypted);

		   //System.out.println("Text Decrpyted : " + new String(textDecrypted));


		   }

catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}

          System.out.println("Sending " + FILE_TO_SEND + "(" + textEncrypted.length + " bytes)");
          os.write(textEncrypted,0,textEncrypted.length);

	 
	
         } os.flush();

          bis.close();
      client.close();

             System.out.println("file transferred...");

          System.out.println("Done.");
}
						

 catch(Exception e)
    {
        System.out.println("Client Exception : "+e.getMessage());
    }     
}
catch(Exception e)
    {
        System.out.println("Client Exception : "+e.getMessage());
    }     
}

}
