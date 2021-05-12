package Assignment.model;
import java.util.*;

public class MainTree {
    private TreeNode root;

    public MainTree() {
        root = null;
    }

    public void insertNode(String key, String parent, String category) {

        if(root == null) { //First child after root in tree
            System.out.println("Running when root is null (MainTree.java)");
            Node newNode = new Node(key, parent);
            TreeNode treeNewNode = new TreeNode(newNode);
            root = treeNewNode;
        }
        else if(root!=null) {
            System.out.println("Running when root is not null (MainTree.java)");
            System.out.println("Key is = " + key + " and parent is = " + parent);
            Node newNode = new Node(key, parent);
            TreeNode treeNewNode = new TreeNode(newNode);
            System.out.println("treeNewNode is = " + treeNewNode.getKey());
            TreeNode parentNode = find(parent);
            System.out.println("parentNode is = " + parentNode.getKey());
            parentNode.addChild(parentNode, treeNewNode); //fail here
            System.out.println("here4");

            for(int k = 0; k < parentNode.getChildSize(); k++) {
                
                System.out.println("Child of " + parentNode.getKey() + " is : " + parentNode.getChild().get(k).getKey());
            }

            if(category!=null) {
                System.out.println("Running category is not null");
                String[] properties = category.split("=|\\,");
                double propertyValue;
                
                for(int j = 0; j < properties.length; j++) {
                    System.out.println("properties["+j+"] = " + properties[j]);
                    if(properties[j].contains("h")) {
                        newNode.seth(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("dm")) {
                        newNode.setdm(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("da")) {
                        newNode.setda(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("de")) {
                        newNode.setde(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("em")) {
                        newNode.setem(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("ea")) {
                        newNode.setea(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("ee")) {
                        newNode.setee(Double.parseDouble(properties[j+1]));
                    }
                    else if(properties[j].contains("s")) {
                        newNode.sets(Double.parseDouble(properties[j+1]));
                    }
                }
                System.out.println("h= " + newNode.geth());
                System.out.println("dm= " + newNode.getdm());
                System.out.println("da= " + newNode.getda());
                System.out.println("de= " + newNode.getde());
                System.out.println("em= " + newNode.getem());
                System.out.println("ea= " + newNode.getea());
                System.out.println("ee= " + newNode.getee());
                System.out.println("s= " + newNode.gets());
                
            }

            System.out.println("Node(" + newNode.getKey() + ")" + " parent is: " + newNode.getParent());
            System.out.print("Parent Node(" + parentNode.getKey() + ")" + " childs are : ");
            for(int n = 0; n < parentNode.getChildSize(); n++) {
                System.out.print(parentNode.getChild().get(n).getKey());
                System.out.print(", ");
            }
            System.out.println();
        }
    }

    public TreeNode find(String inKey) {
        TreeNode foundNode = null;
        if(root.isEmpty()) {
            System.out.println("Tree is empty!");
        }
        else if(root.getKey().equals(inKey)) { // Root is the key
            foundNode = root;
        }
        else { // If not at root
            System.out.println("Root is = " + root.getKey());
            foundNode = findRecursive(root, inKey);
        }
        return foundNode;
    }

    public TreeNode findRecursive(TreeNode startNode, String inKey) {
        TreeNode foundNode = null;
        System.out.println("startNode has child of = " + startNode.getChild().size());
        for(int i = 0; i < startNode.getChild().size(); i++) {
            if(startNode.getChild().get(i).getKey().equals(inKey)) {
                System.out.println("Now at child["+i+"]" + "= " + startNode.getChild().get(i).getKey());
                foundNode = startNode.getChild().get(i);
                System.out.println("IAMMMM HEREE");

            }
            else if(!startNode.getChild().get(i).getChild().isEmpty()){
                System.out.println("HEREE");
                if(foundNode != null) {
                    return foundNode;
                }
                foundNode = findRecursive(startNode.getChild().get(i), inKey);
            }
        }
        if(foundNode == null) {
            System.out.println("Did not found any node with key = " + inKey);
        }        
        return foundNode;
    }


    public void displayTree() {
        preOrder(root, 0);
    }

    public void displayTotalPowerConsumption() {
        double[] data = new double[8];
        data = displayTotalPower(root,data);
        System.out.println("\nWeekday morning     :\t" + data[0]);
        System.out.println("Weekday afternoon   :\t" + data[1]);
        System.out.println("Weekday evening     :\t" + data[2]);
        System.out.println("Weekend morning     :\t" + data[3]);
        System.out.println("Weekend afternoon   :\t" + data[4]);
        System.out.println("Weekend evening     :\t" + data[5]);
        System.out.println("Heatware            :\t" + data[6]);
        System.out.println("Special event       :\t" + data[7]);

    }

    /* 
    Import: currNode (TreeNode), data (double[])
    Export: displayTree (double[])
    */
    public void preOrder(TreeNode currNode, int indent) {
        System.out.println(currNode.getKey());
        indent++;
        for(TreeNode child : currNode.getChild()) {
            for(int i = 0; i < indent; i++) {
                System.out.print("    ");
            }
            preOrder(child, indent);
        }
    }

    /* 
    Import: currNode (TreeNode), data (double[])
    Export: totalPower (double[])
    */
    public double[] displayTotalPower(TreeNode currNode, double[] data) {
        double[] totalPower = data;
        
        for(TreeNode child : currNode.getChild()) {
            if(child.getdm()>0) {
                totalPower[0] = totalPower[0] + child.getdm();
            }
            if(child.getda()>0) {
                totalPower[1] = totalPower[1] + child.getda();
            }
            if(child.getde()>0) {
                totalPower[2] = totalPower[2] + child.getde();
            }
            if(child.getem()>0) {
                totalPower[3] = totalPower[3] + child.getem();
            }
            if(child.getea()>0) {
                totalPower[4] = totalPower[4] + child.getea();
            }
            if(child.getee()>0) {
                totalPower[5] = totalPower[5] + child.getee();
            }
            if(child.geth()>0) {
                totalPower[6] = totalPower[6] + child.geth();
            }
            if(child.gets()>0) {
                totalPower[7] = totalPower[7] + child.gets();
            }
            displayTotalPower(child, totalPower);
        }
        return totalPower;
    }

    public boolean isEmpty() {
        boolean check = false;
        if(root==null) {
            check = true;
        }
        return check;
    }

}

