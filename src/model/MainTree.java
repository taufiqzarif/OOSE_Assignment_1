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


    public String display() {
        return preOrder(root, 0);
    }

    public String preOrder(TreeNode currNode, int type) {
        String displayTree = "";
        System.out.println(currNode.getKey());
        type++;
        for(TreeNode child : currNode.getChild()) {
            for(int i = 0; i < type; i++) {
                System.out.print("    ");
            }
            preOrder(child, type);
        }
        return displayTree;
    }
}

