package test;

import java.util.*;
import java.io.Serializable;

/**
* Created by Joker on 2017/5/27.
*/
public class TreeNode<T> implements Serializable {

   private TreeNode parentNode;
   private T nodeEntity;
   private List<TreeNode> childNodes;

   private int parentId;
   
   private int selfId;
    
   protected String nodeName;
   
   
   public int getParentId() {
	return parentId;
}

public void setParentId(int parentId) {
	this.parentId = parentId;
}

public int getSelfId() {
	return selfId;
}

public void setSelfId(int selfId) {
	this.selfId = selfId;
}

public String getNodeName() {
	return nodeName;
}

public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
}

public TreeNode (T nodeEntity){
       this.nodeEntity=nodeEntity;
   }

   public TreeNode (){}

   public void addChildNode(TreeNode childNode){
       childNode.setParentNode(this);
       if ( this.childNodes==null){
           this.childNodes = new ArrayList<TreeNode>();
       }
       this.childNodes.add(childNode);
   }

   public void removeChildNode(TreeNode childNode){
       if (this.childNodes!=null){
           this.childNodes.remove(childNode);
       }
   }
   
   
   /**
    * 插入新结点          输入父结点id进行定位 ，将新结点 插入到父结点的 sonList 中
    * @param changeNode  传入根结点,传入前需判断:若根结点不存在，待插入结点成为根结点，不必进入此方法
    * @param fatherId    新结点的 父结点id
    * @param newNode     新结点
    */
   public boolean insertJuniorNode(TreeNode treeNode)
   {
       int parentId = treeNode.getParentId();
       if(this.selfId == parentId)
       {
           addChildNode(treeNode);
           return true;
       }
       else
       {
           if(childNodes == null || childNodes.isEmpty())
           {
               return false;
           }
           for(TreeNode node:childNodes)
           {
               boolean f = node.insertJuniorNode(treeNode);
               if(f)
               {
                   return true;
               }
           }
       }
       return false;
   }
   
   public TreeNode getParentNode() {
       return parentNode;
   }

   public void setParentNode(TreeNode parentNode) {
       this.parentNode = parentNode;
   }

   public T getNodeEntity() {
       return nodeEntity;
   }

   public void setNodeEntity(T nodeEntity) {
       this.nodeEntity = nodeEntity;
   }

   public List<TreeNode> getChildNodes() {
       return childNodes;
   }

   public void setChildNodes(List<TreeNode> childNodes) {
       this.childNodes = childNodes;
   }

@Override
public String toString() {
	return "TreeNode [parentNode=" + parentNode + ", parentId=" + parentId + ", selfId=" + selfId + ", nodeName="
			+ nodeName + "]";
}
   
   
}
