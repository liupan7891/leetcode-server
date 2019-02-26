package test;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.NodeList;

public class TreeNodeTest {

	public static void main(String[] args) {
		TreeNode node = new TreeNode<>();
		node.setParentId(0);
		node.setSelfId(0);
		node.setNodeName("node_1");
		node.setParentNode(node);
		TreeNode node2 = new TreeNode<>();
		node.setParentId(0);
		node.setSelfId(2);
		node.setNodeName("node_2");
		TreeNode node3 = new TreeNode<>();
		node.setParentId(0);
		node.setSelfId(3);
		node.setNodeName("node_3");
		TreeNode node4 = new TreeNode<>();
		node.setParentId(0);
		node.setSelfId(4);
		node.setNodeName("node_4");
		
		node.addChildNode(node2);
		node.addChildNode(node3);
		node.addChildNode(node4);
		node2.setParentNode(node);
		node3.setParentNode(node);
		node4.setParentNode(node);
		TreeNode node5 = new TreeNode<>();
		node5.setParentId(2);
		node5.setSelfId(5);
		node5.setNodeName("node_5");
		TreeNode node6 = new TreeNode<>();
		node6.setParentId(2);
		node6.setSelfId(6);
		node6.setNodeName("node_6");
		node5.setParentNode(node2);
		node6.setParentNode(node2);
		TreeNode node7 = new TreeNode<>();
		node7.setParentId(3);
		node7.setSelfId(7);
		node7.setNodeName("node_7");
		
		node3.addChildNode(node7);
		node7.setParentNode(node3);
		
		TreeNode node9 = new TreeNode<>();
		node9.setParentId(7);
		node9.setSelfId(9);
		node9.setNodeName("node_9");

		List<TreeNode> treeNodes = new ArrayList();
		treeNodes.add(node9);
		node7.setChildNodes(treeNodes);
		
		treeNodes = new ArrayList();
		treeNodes.add(node7);
		node3.setChildNodes(treeNodes);
		
		treeNodes = new ArrayList();

		treeNodes.add(node5);
		treeNodes.add(node6);
		node2.setChildNodes(treeNodes);
		
		treeNodes = new ArrayList();
		
		treeNodes.add(node2);
		treeNodes.add(node3);
		treeNodes.add(node4);
		
		node.setChildNodes(treeNodes);
		
		treeNodes = node.getChildNodes();
		
		System.out.println(treeNodes);
		System.out.println(deletionTree(treeNodes));
		
	}
	
	public static TreeNode deletionTree(List<TreeNode> treeNodes){  
		if(treeNodes == null || treeNodes.size() < 0)  
	            return null;  
	          
        TreeNode newTree =  new TreeNode();  
        List<TreeNode> nodes = treeNodes;
        
        //将所有节点添加到多叉树中  
        for(TreeNode treeNode : treeNodes) {  
        	//非父节点
            if(treeNode.getParentId() != 0 && treeNode.getSelfId() != treeNode.getParentId()){  
                //向根添加一个节点 
            	if(treeNode.getChildNodes()!=null && treeNode.getChildNodes().size() ==1){
            		TreeNode childNode = (TreeNode) treeNode.getChildNodes().get(0);
            		childNode.setParentId(treeNode.getParentId());
            		nodes.remove(treeNode);
            		
            		
            	}
            }  
        }
        
        newTree.setChildNodes(nodes);
	          
        return newTree;  
	    
	}  
	      
}
