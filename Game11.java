/*
javac Game11.java
java Game11

jar -cvfe Game11.jar Game11 Game11.class
java -jar Game11.jar
*/

import java.io.*;
import java.util.*;

class Game11
{
	public static void main(String args[])
	{
	 int[][] arr = new int [4][4];
	 int i=0, j=0, m=0, turn=0, correct=0, flag=1, chk=0, t1, t2, x=0, y=0;

	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 Scanner s = new Scanner(System.in);

		try
		{
	 	 System.out.println("The 2D array is \n");
			for(i=0; i<3; i++)
			{
				for(j=0; j<3; j++)
				{
			 	 arr[i][j] = (10 * (i+1)) + (j+1);
			 	 System.out.print("  " + arr[i][j]);
				}
		 	 System.out.println("\n");
			}
		
		 System.out.println("Player 1 is marked by 66");
		 System.out.println("Player 2 is marked by 99");
			while(m==0)
			{
	/* max 9 turns */	for(turn=0; turn<9; turn++)
				{
				 chk=0;
	/* move for player1 */		if(flag==1)
					{
					 flag=2;
						while(correct==0)
						{
			 	 	 	 System.out.println("Turn of player 1. Enter the index where u want to put your mark (Press 0 to exit).");
							
                                           /***************************************************************/
						 String s1 = br.readLine();
							if(s1.equals("") || s1 == null)
							{
						  	 System.out.println("Blank or NULL input not allowed ! ");
						  	 continue;
							}
					/******************************************************************/
							if( s1.equals("0") )
							{
                                           	 	 System.out.println("Quit from game!");
                                           		 System.exit(0);
                                         		}

					/******************************************************************/
						 	if( (Character.isDigit(s1.charAt(0)) != true )   ||  (Character.isDigit(s1.charAt(1)) != true) )
							{
							 System.out.println("Character input not allowed");
							 continue;
							}

					/******************************************************************/
			 	 	 	 t1 = Integer.parseInt(s1);
                                         		if(t1 == 0)
                                         		{ 
                                           	 	 System.out.println("Quit from game!");
                                           		 System.exit(0);
                                         		}
					 	 x = t1/10;
	 				 	 y = t1%10;
	/* check valid move or not */			if( ((x==1) || (x==2) || (x==3))  &&  ((y==1) || (y==2) || (y==3)) )
							{
	/* check duplicate move or not */			if( (arr[x-1][y-1] != 66)  &&  (arr[x-1][y-1] != 99) )
								{
							 	 correct = 1;
					 		 	 arr[x-1][y-1] = 66;
								}
							}
							if(correct==0)
							{
							 System.out.println("!!! ERROR !!!  Wrong move");
							}
						}
					 correct = 0;
					}

	/* move for player2 */		else if(flag==2)
					{
					 flag=1;
						while(correct==0)
						{
			 	 	 	 System.out.println("Turn of player 2. Enter the index where u want to put your mark (Press 0 to exit).");
                                           /***************************************************************/
						 String s2 = br.readLine();
							if(s2.equals("") || s2 == null)
							{
						  	 System.out.println("Blank or NULL input not allowed ! ");
						  	 continue;
							}
					/******************************************************************/
							if( s2.equals("0") )
							{
                                           	 	 System.out.println("Quit from game!");
                                           		 System.exit(0);
                                         		}

					/******************************************************************/
						 	if( (Character.isDigit(s2.charAt(0)) != true )   ||  (Character.isDigit(s2.charAt(1)) != true) )
							{
							 System.out.println("Character input not allowed");
							 continue;
							}

					/******************************************************************/
			 	 	 	 t2 = Integer.parseInt(s2);                      
					 		if(t2 == 0)
                                         		{ 
                                           	 	 System.out.println("Quit from game!");
                                           		 System.exit(0);
                                         		}
					 	 x = t2/10;
	 				 	 y = t2%10;
							if( ((x==1) || (x==2) || (x==3))  &&  ((y==1) || (y==2) || (y==3)) )
							{
								if( (arr[x-1][y-1] != 66)  &&  (arr[x-1][y-1] != 99) )
								{
							 	 correct = 1;
					 		 	 arr[x-1][y-1] = 99;
								}
							}
							if(correct==0)
							{
							 System.out.println("!!! ERROR !!!  Wrong move");
							}
						}
					 correct = 0;
					}
					
	/* print the 2D array */	System.out.println("\n");
					for(i=0; i<3; i++)
					{
						for(j=0; j<3; j++)
						{
			 			 System.out.print("  " + arr[i][j]);
						}
		 			 System.out.println("\n");
					}


					if(turn>3)
					{
	/* vertical checking */			for(j=0; j<3; j++)
						{
							if( (arr[0][j] == arr[1][j])  &&  (arr[1][j] == arr[2][j]) )
							{
						 		if(arr[0][j] == 66)
						 		{
						  		 System.out.println("Player 1 wins");
						  		 chk = 1;
								 break;
						 		}
						 		else if(arr[0][j] == 99)
						 		{
						  		 System.out.println("Player 2 wins");
						  		 chk = 1;
								 break;
						 		}
							}
						}
						
	/* horizontal checking */ 		for(i=0; i<3; i++)
						{
							if( (arr[i][0] == arr[i][1])  &&  (arr[i][1] == arr[i][2]) )
							{
						 		if(arr[i][0] == 66)
						 		{
						  		 System.out.println("Player 1 wins");
						  		 chk = 1;
								 break;
						 		}
						 		else if(arr[i][0] == 99)
						 		{
						  		 System.out.println("Player 2 wins");
						  		 chk = 1;
								 break;
						 		}
							}
						}

						if(chk==1){break;}
			 
	/* left diagonal checking */		if( (arr[0][0] == arr[1][1])  &&  (arr[1][1] == arr[2][2]) )
						{
							if(arr[0][0] == 66)
							{
						  	 System.out.println("Player 1 wins");
						  	 turn = 0;
							 break;
						 	}
						 	else if(arr[0][0] == 99)
						 	{
						  	 System.out.println("Player 2 wins");
						  	 turn = 0;
							 break;
						 	}
							
						}

	/* right diagonal checking */		else if( (arr[0][2] == arr[1][1])  &&  (arr[1][1] == arr[2][0]) )
						{
							if(arr[0][2] == 66)
							{
						  	 System.out.println("Player 1 wins");
						  	 turn = 0;
							 break;
						 	}
						 	else if(arr[0][2] == 99)
						 	{
						  	 System.out.println("Player 2 wins");
						  	 turn = 0;
							 break;
						 	}
						}
					}
				}
			 if(turn == 9) { System.out.println("Match draw"); }
			 
			 System.out.println("Do you want to play again ? (0=yes . 1=no) ");
			 m=s.nextInt();
				if(m==0)
				{
				 turn=0;
					for(i=0; i<3; i++)
					{
						for(j=0; j<3; j++)
						{
			 	 		 arr[i][j] = (10 * (i+1)) + (j+1);
			 	 		 System.out.print("  " + arr[i][j]);
						}
		 	 		 System.out.println("\n");
					}
				}
				else {System.out.println("!!! Quit from Game !!!");}
			}
		}
 
		catch(Exception e){e.printStackTrace();} 
	}
}
