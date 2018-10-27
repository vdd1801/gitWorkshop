import java.net.*;
import java.io.*;


class TICTAC_server
{

	static TICTAC_server ts = new TICTAC_server();
		
		
	static NticTac obj1 = new NticTac("O",ts);
	static Socket s;
	public static void main(String args[]) throws Exception
	{
		
		obj1.setSize(400,400);
		obj1.setVisible(true);
		receive();
		
	}
	
	static void receive()
	{
		
		try
		{
		
		ServerSocket ss = new ServerSocket(9000);
		System.out.println("Player is waiting...");
		 s = ss.accept();
		InputStream is = s.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		  

		String x = br.readLine();
		String data[] = x.split("~");
		System.out.println("The answer="+data[0]+" "+data[1]); 
		
		obj1.setPlayerMove("X",Integer.parseInt(data[1]),Integer.parseInt(data[0]));
		
		
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		
		
	}
	
	void send(String idx_chance) 
	{
		
		try
		{
		
		
		
		OutputStream os = s.getOutputStream();  		
		OutputStreamWriter osw = new OutputStreamWriter(os); 
		PrintWriter pw = new PrintWriter(osw,true);    
		
		idx_chance = obj1.getIndexChance();
		
		pw.println(idx_chance);
		
		
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}


}