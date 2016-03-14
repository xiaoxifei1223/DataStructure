package org.lines.Datastructure;

public class Binarytree {
	private Node root;
	
//ɾ������,ɾ���ɹ�����true��ʧ�ܷ���false----------------------
	public boolean delete(int key){
		Node father=root;
		Node current=root;
		Node successor;
		boolean isLeft=true;
		boolean havechild=false;
		while(current.getData()!=key){		//�ҵ�ָ����ֵ��Ӧ�Ľڵ�
			father=current;
			
			if(current.getData()<key){
				current=current.leftchild;
				isLeft=true;
			}
			else{
				current=current.rightchild;
				isLeft=false;
			}
			if(current==null)
				return false;
		}
		if(current.leftchild==null&&current.rightchild==null)		//�ж��Ƿ�ΪҶ�ӽڵ�
			havechild=false;
		else
			havechild=true;
		
		if(havechild==false){		//Ҷ�ӽڵ��ɾ��
			if(current==root)
				root=null;
			else{
				if(isLeft)
					father.leftchild=null;
				else
					father.rightchild=null;
			}
			
		}
		else{		//��Ҷ�ӽڵ�ɾ��
			boolean haveTwoChilds=false;		//�ж��Ƿ�ֻ��һ���ӽڵ�
			if(current.leftchild==null||current.rightchild==null)
				haveTwoChilds=false;
			else
				haveTwoChilds=true;
			
			if(!haveTwoChilds){		//ֻ��һ���ӽڵ�
				if(current.rightchild==null){		//Ԥɾ���ڵ���ӽڵ�Ϊ��ڵ�
					if(current==root)
						root=current.leftchild;
					else if(isLeft)
						father.leftchild=current.leftchild;
					else
						father.rightchild=current.leftchild;
				}
				else{		//Ԥɾ���ڵ���ӽڵ�Ϊ�ҽڵ�
					if(current==root)
						root=current.rightchild;
					else if(isLeft)
						father.leftchild=current.rightchild;
					else
						father.rightchild=current.rightchild;
				}
				
			}
			else{		//Ԥɾ���Ľڵ���������ӽڵ�
				successor=getSuccessor(current);
				if(current==root){
					root=successor;
				}
				else if(isLeft)
					father.leftchild=successor;
				else
					father.rightchild=successor;
				successor.leftchild=current.leftchild;
					
				
			}
		}
	
		
		return true;
	}//end of delete
	
//�ھ���˫�ӽڵ������Ѱ�Һ�̽ڵ㣬����Node�ͺ�̽ڵ�--------------
	public Node getSuccessor(Node dd){
		Node successorfather=dd;
		Node successor=dd;
		Node current=dd.rightchild;
		while(current!=null){
			successorfather=successor;
			successor=current;
			current=current.leftchild;
		}
		if(successor!=dd.rightchild){
			successorfather.leftchild=successor.rightchild;
			successor.rightchild=dd.rightchild;
		}
		return successor;
	}


}
//end of class Binarytree
class Node{
	private int data;
	public Node leftchild;
	public Node rightchild;
//��ȡ��int��data------------
	public int getData(){
		return this.data;
	}
}
