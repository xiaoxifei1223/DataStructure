package org.lines.Datastructure;

public class Quicksort {
	
	public void quicksort(long[] array,int top, int end){
		if(top<end){
			long q=partion(array,top,end);
			quicksort(array,top,(int)q-1);
			quicksort(array,(int)q+1,end);
		}
	}
	
	public long partion(long[] array,int top,int end){
		long x=array[end];
		int i=top-1;
		for(int j=top;i<end;j++){
			if(array[j]<array[end]){
				i=i+1;
				long temp=array[i];
				array[i]=array[j];
				array[j]=temp;
			}
		}
		long temp=array[i+1];
		array[i+1]=array[end];
		array[end]=temp;
		
		return array[i+1];
	}

}
