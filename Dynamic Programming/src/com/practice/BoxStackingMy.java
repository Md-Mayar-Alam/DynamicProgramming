package com.practice;

import java.util.Scanner;



public class BoxStackingMy {
	
	static class Box{
		int height;
		int width;
		int depth;

		Box(int height, int width, int depth){
			this.height= height;
			this.width= width;
			this.depth= depth;
		}
	}

	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		
		int noOfTestCases= sc.nextInt();
		
		for(int i=0; i< noOfTestCases; i++) {
			int noOfBox= sc.nextInt();
			
			int boxArray[][]= new int[noOfBox][3];
			
			for(int j=0; j< noOfBox; j++) {
				boxArray[j][0]= sc.nextInt();
				boxArray[j][1]= sc.nextInt();
				boxArray[j][2]= sc.nextInt();
			}
			
			int maxHeight= findMaxHeight(boxArray);
			System.out.println("# "+ (i+1) +" "+maxHeight); 
			
			/*Box boxArray[]= new Box[noOfBox];
			
			for(int j=0; j< noOfBox; j++) {
				int height= sc.nextInt();
				int width= sc.nextInt();
				int depth= sc.nextInt();
				
				boxArray[j]= new Box(height, width, depth);
			}
			
			int maxHeight= findMaxHeight(boxArray);
			System.out.println("# "+ (i+1) +" "+maxHeight);*/
		}
	}

	private static int findMaxHeight(int[][] boxArray) {
		int boxArrayLength= boxArray.length;
		Box box[]= new Box[boxArrayLength * 3];
		
		for(int i=0; i< boxArrayLength; i++) {
			int height= boxArray[i][0];
			int width= boxArray[i][1];
			int depth= boxArray[i][2];
			
			/*box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(width, height, depth);
			box[i*3 + 2]= new Box(depth, height, width);*/
			
			/*box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(width, depth, height);
			box[i*3 + 2]= new Box(depth, height, width);*/
			
			/*box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(height, depth, width);
			box[i*3 + 2]= new Box(depth, height, width);*/
			
			box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(width, height, depth);
			box[i*3 + 2]= new Box(depth, height, width);
			
			/*box[i*3]= new Box(height, width, depth);
			box[i*3 + 1]= new Box(width, depth, height);
			box[i*3 + 2]= new Box(depth, height, width);*/
			
			/*box[i*3]= new Box(height, max(width, depth), min(width, depth) );
			box[i*3 + 1]= new Box(width, max(height, depth), min(height, depth));
			box[i*3 + 2]= new Box(depth, max(height, width), min(height, width));*/
		}
		
		System.out.println("Boxes before sorting");
		
		for(int i=0; i< box.length; i++) {
			System.out.println("H "+ box[i].height + " W "+ box[i].width + " D "+ box[i].depth);
		}
		
		/*sort(box);
		
		System.out.println("Boxes after sorting");
		
		for(int i=0; i< box.length; i++) {
			System.out.println("H "+ box[i].height + " W "+ box[i].width + " D "+ box[i].depth);
		}*/
		
		int boxHeight[]= new int[box.length];
		
		for(int i=0; i< boxHeight.length; i++) {
			boxHeight[i]= box[i].height;
		}
		
		for(int i=3; i< box.length; i++) {
			int val= 0;
			boxHeight[i]= 0;
			
			int indexToCompare= -1;
			if(i % 3 == 0) {
				indexToCompare= i;
			}else if(i % 3 == 1) {
				indexToCompare= i-1;
			}else if(i % 3 == 2) {
				indexToCompare= i-2;
			}
			
			for(int j=0; j< indexToCompare; j++) {
				/*if(box[i].width <= box[j].width && box[i].depth <= box[j].depth) {
					val= max(val, boxHeight[j]);
				}*/
				
				if(box[i].width <= box[j].width && box[i].depth <= box[j].depth) {
					val= max(val, boxHeight[j]);
				}
			}
			
			/*int indexToCompare= -1;
			
			int indexJStart= -1;
			
			if(i < 3) {
				indexJStart= 3;
				indexToCompare= box.length;
			}else {
				indexJStart= 0;
				if(i % 3 == 0) {
					indexToCompare= i;
				}else if(i % 3 == 1) {
					indexToCompare= i-1;
				}else if(i % 3 == 2) {
					indexToCompare= i-2;
				}
			}
			
			for(int j=indexJStart; j< indexToCompare; j++) {
				if(box[i].width <= box[j].width && box[i].depth <= box[j].depth) {
					val= max(val, boxHeight[j]);
				}
				
				if(box[i].width >= box[j].width && box[i].depth >= box[j].depth) {
					val= max(val, boxHeight[j]);
				}
			}*/
			boxHeight[i]= val + box[i].height;
		}
		
		return max(boxHeight);
	}

	private static int min(int width, int depth) {
		return width < depth ? width : depth;
	}

	private static int max(int[] boxHeight) {
		int max= -1;
		for(int height: boxHeight) {
			if(height > max) {
				max= height;
			}
		}
		return max;
	}

	private static int max(int val, int boxHeight) {
		return val > boxHeight ? val : boxHeight;
	}

	private static void sort(Box[] box) {
		
		for(int i=0; i< box.length; i++) {
			for(int j=i+1; j< box.length; j++) {
				int area1= box[i].width * box[i].depth;
				int area2= box[j].width * box[j].depth;
				
				if(area1 < area2) {
					Box temp= box[i];
					box[i]= box[j];
					box[j]= temp;
				}
			}
		}
		
	}
}
