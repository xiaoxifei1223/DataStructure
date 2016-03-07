package org.lines.Datastructure;

public class Insertsort {
	//ÉıĞòÅÅÁĞ£¬
	public void insertionsort(long[] array,int nElems){
		int in, out;
		
		for(out=1;out<nElems;out++){
			long temp=array[out];
			in=out;
			while(in>0&&array[in-1]>=temp){
				array[in]=array[in-1];
				--in;
			}
			array[in]=temp;
		}
	}

}
