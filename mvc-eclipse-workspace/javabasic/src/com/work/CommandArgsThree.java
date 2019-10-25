package com.work;

public class CommandArgsThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String [][] argCopy = new String[2][2];
	  int x=0;
      argCopy[0] = args;
      x = argCopy[0].length;

	  //System.out.println(x);
      for (int y = 0; y <x; y++) 
      {
          System.out.print(" " + argCopy[0][y]);
      }

	
	}

}
