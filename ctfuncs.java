import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class ctfuncs
{

		//putting into AES to encrypt
		static byte[] encrypt_data(byte[] data) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, 
		IllegalBlockSizeException, BadPaddingException{
			String key = "bad8deadcafef00d";

			/*SecretKeySpec(byte[] key, String algorithm)
			Constructs a secret key from the given byte array.*/
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

			//provide details for mode and padding scheme
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

			//init(int opmode, Key key) Initializes this cipher mode with a key.
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

			// public final byte[] doFinal(byte[] input)
			byte[] ct = cipher.doFinal(data);
	        	return ct;
	   	}
		
		//generate IV with random()
		public static void IVgen(LinkedList<Integer> IVrand){
			Random rand = new Random();
			
			for(int i = 0; i < 128; i++){
				//each bit
				int r = rand.nextInt(15)+1;//15 is max number in a bit,1 is min
				IVrand.add(r);
			}
		
		}
		
/*
 * Can't think of a way to make this all in one function.. at least in a pretty way
 * 
 * 
		//parses the user's input
		public static void user_input ( String[] args )
		{
			
			for ( int i = 0; i < args.length; i++ )
			{
				//-i <input file>:  required, specifies the path of the file that is being operated on
				if ( args[i].equals("-i") )
				{
					System.out.println( args[i+1] );
					//open file input file
					i++;
				}
				//-k <key file>:  required, specifies a file storing a valid AES key as a hex encoded string
				if ( args[i].equals("-k") )
				{
					System.out.println( args[i+1] );
					//open file key file
					i++;
				}
				//-o <output file>: required, specifies the path of the file where the resulting output is stored
				if ( args[i].equals("-o") )
				{
					System.out.println( args[i+1] );
					//make output file
					i++;
				}
				//-v <iv file>:  optional, specifies the path of a file storing a valid IV as a hex encoded string,
				// if not present a random IV should be generated
				if ( args[i].equals("-v") )
				{
					System.out.println( args[i+1] );
					//open file i file
					i++;
				}
				
			}
						
		}
		
*/
		//parses the user's input
		public static String key_file ( String[] args )
		{
			
			for ( int i = 0; i < args.length; i++ )
			{
				//-k <key file>:  required, specifies a file storing a valid AES key as a hex encoded string
				if ( args[i].equals("-k") )
				{
					System.out.println( args[i+1] );
					//open key file
					i++;
					break;
				}
			}
			
			return "key";
						
		}
		
		public static String input_file ( String[] args )
		{
			
			for ( int i = 0; i < args.length; i++ )
			{
				//-i <input file>:  required, specifies the path of the file that is being operated on
				if ( args[i].equals("-i") )
				{
					System.out.println( args[i+1] );
					//open input file
					i++;
					break;
				}
			}
			
			return "input";
						
		}
		
		public static void output_file ( String[] args, String output )
		{
			
			for ( int i = 0; i < args.length; i++ )
			{
				//-o <output file>: required, specifies the path of the file where the resulting output is stored
				if ( args[i].equals("-o") )
				{
					System.out.println( args[i+1] );
					//make output file
					i++;
					break;
				}
			}
			
			//put results in output file
						
		}
		
		public static String iv_file ( String[] args )
		{
			int iv_found = -1;
			for ( int i = 0; i < args.length; i++ )
			{
				//-v <iv file>:  optional, specifies the path of a file storing a valid IV as a hex encoded string,
				// if not present a random IV should be generated
				if ( args[i].equals("-v") )
				{
					System.out.println( args[i+1] );
					//open file i file
					i++;
					iv_found = 1;
					break;
				}
			}
			
			if( iv_found == 1 )
			{
				return "IV";
			}
			else
			{
				return "-1";
			}
						
		}
		
		//need to make open/close file functions
		
		
}
