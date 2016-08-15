import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class mydes1
{
	public static void main(String[] args) {



									BufferedReader br = null;

									try 
									{
										String sCurrentLine,store;
	
										br = new BufferedReader(new FileReader("C:\\teh.txt"));

										while ((sCurrentLine = br.readLine()) != null)
										 {
											System.out.println(sCurrentLine);
										}	

									}
									catch (IOException e) 
									{
										e.printStackTrace();
									} 
									finally 
									{
										try 
										{
											if (br != null)br.close();
										}
										 catch (IOException ex) 
										{
											ex.printStackTrace();
										}
									}


		try{

		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    SecretKey myDesKey = keygenerator.generateKey();

		    Cipher desCipher;

		    // Create the cipher
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

		    //sensitive information
			
			FileInputStream fileInputStream=null;

        File file = new File("C:\\teh.txt");

        byte[] bFile = new byte[(int) file.length()];

        try {
            //convert file into array of bytes
	    fileInputStream = new FileInputStream(file);
	    fileInputStream.read(bFile);
	    fileInputStream.close();

	    /*for (int i = 0; i < bFile.length; i++) {
	       	System.out.print((char)bFile[i]);
            }*/

	    //System.out.println("Done");
        }catch(Exception e){
        	e.printStackTrace();
        }





		    System.out.println("Text [Byte Format] : " + bFile);

		    System.out.println("Text : " + new String(bFile));

		    // Encrypt the text
		    byte[] textEncrypted = desCipher.doFinal(bFile);

		    System.out.println("Text Encryted : " + textEncrypted);

		    // Initialize the same cipher for decryption
		    desCipher.init(Cipher.DECRYPT_MODE, myDesKey);

		    // Decrypt the text
		    byte[] textDecrypted = desCipher.doFinal(textEncrypted);

		    System.out.println("Text Decryted : " + new String(textDecrypted));

		}catch(NoSuchAlgorithmException e){
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

	}
}