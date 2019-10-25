package com.test;

public class Oraganaization {
	
	
	public static void main(String[] args ) {
		
		employeeedao dao=new employeeedao() {

			@Override
			public void show(int i) {
				// TODO Auto-generated method stub
				System.out.println("sri "+i);

			}

			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("ram");

			}

			@Override
			public void test() {
				// TODO Auto-generated method stub
				System.out.println("prithvi");

			}
			
		};
		dao.show(22);
	}

}
