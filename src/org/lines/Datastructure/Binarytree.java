package org.lines.Datastructure;

public class Binarytree {
	private Node root;
	
//删除方法,删除成功返回true，失败返回false----------------------
	public boolean delete(int key){
		Node father=root;
		Node current=root;
		Node successor;
		boolean isLeft=true;
		boolean havechild=false;
		while(current.getData()!=key){		//找到指定键值对应的节点
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
		if(current.leftchild==null&&current.rightchild==null)		//判断是否为叶子节点
			havechild=false;
		else
			havechild=true;
		
		if(havechild==false){		//叶子节点的删除
			if(current==root)
				root=null;
			else{
				if(isLeft)
					father.leftchild=null;
				else
					father.rightchild=null;
			}
			
		}
		else{		//非叶子节点删除
			boolean haveTwoChilds=false;		//判断是否只有一个子节点
			if(current.leftchild==null||current.rightchild==null)
				haveTwoChilds=false;
			else
				haveTwoChilds=true;
			
			if(!haveTwoChilds){		//只有一个子节点
				if(current.rightchild==null){		//预删除节点的子节点为左节点
					if(current==root)
						root=current.leftchild;
					else if(isLeft)
						father.leftchild=current.leftchild;
					else
						father.rightchild=current.leftchild;
				}
				else{		//预删除节点的子节点为右节点
					if(current==root)
						root=current.rightchild;
					else if(isLeft)
						father.leftchild=current.rightchild;
					else
						father.rightchild=current.rightchild;
				}
				
			}
			else{		//预删除的节点具有两个子节点
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
	
//在具有双子节点情况下寻找后继节点，返回Node型后继节点--------------
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
//获取，int型data------------
	public int getData(){
		return this.data;
	}
}
