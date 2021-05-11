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
    private double data = 0;
    private Map<String,Double> value = new HashMap<String,Double>();

    public TreeNode(Node currNode) {
        this.currNode = currNode;
        child = new ArrayList<TreeNode>();
    }

    // Setters

    public void addChild(TreeNode currentNode, TreeNode newNode) {
        currentNode.child.add(newNode);
    }

    // public Map<String,Double> getMapData() {
    //     if(this.currNode.getdm()!=0) {
    //         value.put("dm", this.currNode.getdm());
    //     }
    //     else if(this.currNode.getda()!=0) {
    //         value.put("da", this.currNode.getda());
    //     }
    //     else if(this.currNode.getde()!=0) {
    //         value.put("de", this.currNode.getde());
    //     }
    //     else if(this.currNode.getem()!=0) {
    //         value.put("em",this.currNode.getem());
    //     }
    //     else if(this.currNode.getea()!=0) {
    //         value.put("ea", this.currNode.getea());
    //     }
    //     else if(this.currNode.getee()!=0) {
    //         value.put("ee",this.currNode.getee());
    //     }
    //     else if(this.currNode.geth()!=0) {
    //         value.put("h",this.currNode.geth());
    //     }
    //     else if(this.currNode.gets()!=0) {
    //         value.put("s",this.currNode.gets());
    //     }
    //     return getMapData;
    // }

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

    public double getdm() {
        return this.currNode.getdm();
    }

    public double getda() {
        return this.currNode.getda();
    }

    public double getde() {
        return this.currNode.getde();
    }

    public double getem() {
        return this.currNode.getem();
    }

    public double getea() {
        return this.currNode.getea();
    }

    public double getee() {
        return this.currNode.getee();
    }

    public double geth() {
        return this.currNode.geth();
    }

    public double gets() {
        return this.currNode.gets();
    }
}

