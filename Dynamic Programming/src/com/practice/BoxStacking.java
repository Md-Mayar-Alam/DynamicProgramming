package com.practice;

public class BoxStacking {

    public int solve(int [][] x){

        Box [] boxes = new Box[x.length*3];
        for (int i = 0; i<x.length ; i++) {
            int h = x[i][0];
            int w = x[i][1];
            int d = x[i][2];
            boxes[i*3] = new Box(h,w,d); //normal dimension
            boxes[i*3+1] = new Box(w,h,d); //first dimension
            boxes[i*3+2] = new Box(d,h,w); //second dimension
        }

        //all options are created.
        //Arrays.sort(boxes);
        sort(boxes);
        //to display all the possible boxes.
        System.out.println("All possible combination of boxes after rotation");
        for (int i = 0; i <boxes.length ; i++) {
            System.out.println(boxes[i].height + " " + boxes[i].width + " " + boxes[i].depth);
        }

        int [] optHeight = new int [boxes.length+1];

        //if there are no boxes then optimal height = 0
        optHeight[0] =0;

        for (int i = 1; i <optHeight.length ; i++) {
            int maxHeightIndex = 0;
            for (int j = i-2; j >=0 ; j--) {
                //first check if box can be placed
                if(boxes[j].width>boxes[i-1].width && boxes[j].depth>boxes[i-1].depth){
                    if(optHeight[maxHeightIndex]<optHeight[j+1]){
                        maxHeightIndex = j+1;
                    }
                }
            }

            optHeight[i]=optHeight[maxHeightIndex] + boxes[i-1].height;
        }
        
        /*for (int i = 2; i <optHeight.length ; i++) {
            int maxHeightIndex = 0;
            for (int j = i-3; j >=0 ; j--) {
                //first check if box can be placed
                if(boxes[j].width>boxes[i-1].width && boxes[j].depth>boxes[i-1].depth){
                    if(optHeight[maxHeightIndex]<optHeight[j+1]){
                        maxHeightIndex = j+1;
                    }
                }
            }

            optHeight[i]=optHeight[maxHeightIndex] + boxes[i-1].height;
        }*/

//        System.out.println(Arrays.toString(optHeight));
       return optHeight[optHeight.length-1];
    }

    public static void main(String[] args) {
        /*int [][] x = { {4, 7, 9},
                       {5, 8, 9},
                       {11, 20, 40},
                       {1, 2, 3} };*/
    	
    	/*int [][]x= {
    			{76, 1, 2},
    			{45, 55, 35}
    	};*/
    	
    	/*int [][]x= {
    			{4, 2, 5},
    			{3, 1, 6},
    			{3, 2, 1},
    			{6, 3, 8}
    	};*/
    	
    	int [][]x= {
    			{5, 4, 2},
    			{5, 3, 1},
    			{8, 6, 3}
    	};
    	
        BoxStacking boxStacking = new BoxStacking();
        System.out.println("Max height which can be obtained :" + boxStacking.solve(x));
    }
    
    public static void sort(Box[] boxes) {
    	
    	for(int i=0; i< boxes.length; i++) {
    		for(int j=i+1; j< boxes.length; j++) {
    			int area1= boxes[i].width * boxes[i].depth;
    			int area2= boxes[j].width * boxes[j].depth;
    			
    			//int res= checkBoxWD(boxes[i], boxes[j]);
    			
    			if(area1 < area2) {
    				Box temp= boxes[i];
    				boxes[i]= boxes[j];
    				boxes[j]= temp;
    			}
    		}
    	}
    }
}

class Box{
    int height;
    int width;
    int depth;
    public Box(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
/*
    public int compareTo(Box o) {
        int area = o.depth*o.width;
        int thisArea = this.depth*this.width;

        return  area - thisArea;
    }*/
}