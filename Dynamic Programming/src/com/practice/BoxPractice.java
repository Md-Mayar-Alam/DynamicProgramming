package com.practice;

import java.util.Scanner;

import com.practice.BoxStackingMy.Box;

public class BoxPractice {
	static class Box{
		int height;
		int width;
		int depth;
		
		public Box(int height, int width, int depth) {
			this.height= height;
			this.width= width;
			this.depth= depth;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		
		int noOfTestCases= sc.nextInt();
		
		for(int i=1; i<= noOfTestCases; i++) {
			int noOfBox= sc.nextInt();
			
			int boxArray[][]= new int[noOfBox][3];
			
			for(int j=0; j< noOfBox; j++) {
				boxArray[j][0]= sc.nextInt();
				boxArray[j][1]= sc.nextInt();
				boxArray[j][2]= sc.nextInt();
			}
			
			int maxHeight= findmaxHeight(boxArray);
			
			System.out.println("# "+ noOfTestCases +" "+ maxHeight);
		}
	}

	private static int findmaxHeight(int[][] boxArray) {
		
		Box box[]= new Box[boxArray.length];
		
		for(int i=0; i< boxArray.length; i++) {
			int height= boxArray[i][0];
			int width= boxArray[i][1];
			int depth= boxArray[i][2];
			
			/*box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(height, depth, width);
			box[i*3 + 2]= new Box(depth, height, width);*/
			
			
			if(height >= width && height >= depth ){
				//box[i]= new Box(height, max(width, depth), min(width, depth) );
				box[i]= new Box(height, width, depth);
			}else if(width >= height && width >= depth) {
				//box[i]= new Box(width, max(height, depth), min(height, depth));
				box[i]= new Box(width, height, depth);
			}else if(depth >= height && depth >= width) {
				//box[i]= new Box(depth, max(height, width), min(height, width));
				box[i]= new Box(depth, height, width);
			}
		}
		
		for(int i=0; i< box.length; i++) {
			System.out.println("H "+ box[i].height + " W "+ box[i].width + " D "+ box[i].depth);
		}
		
		return 0;
	}

	private static int min(int width, int depth) {
		return width < depth ? width : depth;
	}

	private static int max(int width, int depth) {
		return width > depth ? width : depth;
	}
}
