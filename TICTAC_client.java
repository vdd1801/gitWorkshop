import java.net.*;
import java.io.*;


class TICTAC_client
{
	static TICTAC_client tc = new TICTAC_client();
	static NticTac obj1 = new NticTac("X",tc);
	public static void main(String args[]) throws Exception
	{
		
	
		obj1.setSize(400,400);
		obj1.setVisible(true);
		
		
	}
	
	void send(String idx_chance) 
	{
		
		try
		{
		Socket s = new Socket("localhost",9000);
		
		
		
		OutputStream os = s.getOutputStream();  		
		OutputStreamWriter osw = new OutputStreamWriter(os); 
		PrintWriter pw = new PrintWriter(osw,true);    
		
		idx_chance = obj1.getIndexChance();
		
		pw.println(idx_chance);
		
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("The answer="+br.readLine());    
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}

}