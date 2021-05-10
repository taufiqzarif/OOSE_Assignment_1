package Assignment.model;
import java.util.*;
/**
 [name]
 [name], [parent-name]
 [name],[parent-name],[cat1]=[power1],[cat2]=[power2],…

 city
 northside,city
 southside,city
 building1,northside,h=675.015,dm=550.8 //leaf
 building2,southside,s=444.2,em=540.1,da=97.9
 building3,southside,ee=10956

 */
public class TreeNode {
    // private Node value;
    private List<TreeNode> child;
    private Node currNode;

    public TreeNode(Node currNode) {
        this.currNode = currNode;
        child = new ArrayList<TreeNode>();
    }

    // Setters

    public void addChild(TreeNode currentNode, TreeNode newNode) {
        currentNode.child.add(newNode);
    }

    public boolean isEmpty() {
        boolean check = false;
        if (child == null) {
            check = true;
        }
        return check;
    }

    public int getChildSize() {
        return this.child.size();
    }

    public List<TreeNode> getChild() {
        return this.child;
    }

    public String getKey() {
        return this.currNode.getKey();
    }
}

