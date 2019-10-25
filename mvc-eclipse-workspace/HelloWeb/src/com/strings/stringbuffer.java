package com.strings;

public class stringbuffer {
	
	protected static void message()
	{
		System.out.println("ram");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      StringBuffer sb=new StringBuffer("kumar");
      StringBuffer sb1=new StringBuffer("ram ");
       sb1.append(sb).append("BE");
       System.out.println(sb1);
     // String s=sb+sb1;
       String s="ram";
       String s1="kumar";
       s.concat(s1);
       System.out.println(s);
       StringBuilder sf=new StringBuilder("sachin");
       StringBuilder sf1=new StringBuilder("tendulkar");
       sf.append(sf1).append("cricket");
       System.out.println(sf);
       
       String ss="1234";
       System.out.println(s.valueOf(ss));
       
       
       long l = 12345L;
       String str = new StringBuilder().append(l).toString();

       System.out.println(str);
       message();
      
	}

}
