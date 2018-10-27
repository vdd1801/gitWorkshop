import java.awt.*;
import java.awt.event.*;



public class NticTac extends Frame implements ActionListener
{
	
	Button b1[] = new Button[9];
	
	
	
	int chance=0;
	int idx;
	TICTAC_client tc_obj;
	TICTAC_server ts_obj;
	
	boolean f;
	String player;
	public NticTac(String p,TICTAC_client tc)
	{
		
		setLayout(new GridLayout(3,3));
		
		player=p;
		for(int i=0;i<9;i++)
		{
			b1[i] = new Button("");
			b1[i].addActionListener(this);
			add(b1[i]);
		}
		tc_obj=tc;
	}
	
	public NticTac(String p,TICTAC_server ts)
	{
		
		setLayout(new GridLayout(3,3));
		
		player=p;
		for(int i=0;i<9;i++)
		{
			b1[i] = new Button("");
			b1[i].addActionListener(this);
			add(b1[i]);
		}
		ts_obj= ts;
	}

	public void actionPerformed(ActionEvent ae)
	{
		
		Button b=null;
		
		int i=0;
		for(i=0;i<b1.length;i++)
		{
			if(b1[i]==ae.getSource())
			{
				
				break;
			}
		}
		
		b = b1[i];
		idx=i;
		
		if(f)
		{
				System.out.println("Plz start a new game!");
		}
		else if(b.getLabel().equals(""))
		{
			
			
			if(chance%2==0 && player.equals("X"))
			{
				b.setLabel("X");
				whoWin("X");
				chance++;
				
				tc_obj.send(getIndexChance());
			}
			else if(chance%2==1 && player.equals("O"))
			{
				b.setLabel("O");
				whoWin("O");
				chance++;
				//ts_obj.send(getIndexChance());
			}
			else
			{
				System.out.println("Illegal move!");	
			}
			
			System.out.println(chance);
		
			
			
		}
		else
		{
				System.out.println("Illegal move!");
		}
		
		
	}
	
	public String getIndexChance()
	{
		return idx+"~"+chance;
	}
	
	void setChance(int c)
	{
		chance=c;
	}
	
	void setPlayerMove(String p,int c,int i)
	{
		chance=c;
		b1[i].setLabel(p);
		
	}
	
	
	
	public void whoWin(String p)
	{
		int i=0;
		f=true;
		
		for(i=0;i<=2;i++)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		}
		
		f=true;
		
		for(i=3;i<=5;i++)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		}
		
		f=true;
		
		for(i=6;i<=8;i++)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		} 
		
		f=true;
		
		for(i=0;i<=6;i+=3)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		}
		
		f=true;
		
		for(i=1;i<=7;i+=3)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		} 
		
		f=true;
		
		for(i=2;i<=8;i+=3)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		} 
		
		f=true;
		
		for(i=0;i<=8;i+=4)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		} 
		
		f=true;
		
		for(i=2;i<=6;i+=2)
		{
				
				if(!b1[i].getLabel().equals(p))
				{
					f=false;
					break;
				}
		}
		
		if(f)
		{
		
			System.out.println("Player "+p+" wins!");
		
			return;
		} 
		
		if(chance==9)
			System.out.println("The game is Drawn");
	}
	
	
}


