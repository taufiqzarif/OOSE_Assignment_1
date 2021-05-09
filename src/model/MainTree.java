package Assignment.model;
import java.util.*;

public class MainTree {
    private TreeNode root;

    public MainTree() {
        root = null;
    }

    public void insertNode(String key, String parent, String[] category) {
//        TreeNode newNode = new TreeNode(key, value);
//        TreeNode currentNode = curNode;
        if(category!=null) {
            System.out.println("Total category: " + category.length);
        }
        if(root == null) { //First child after root in tree
            System.out.println("Running when root is null (MainTree.java)");
            Node newNode = new Node(key, parent);
            TreeNode treeNewNode = new TreeNode(newNode);
            root = treeNewNode;
        }
        else if(root!=null) {
            System.out.println("Running when root is not null (MainTree.java)");
            Node newNode = new Node(key, parent);
            TreeNode treeNewNode = new TreeNode(newNode);

            if(category!=null) {
                System.out.println("Running category is not null");
                String values = "s=1,d=2";
                String[] properties = values.split("=|\\,");
                // for(int i = 0; i < category.length; i++) {
                //     values += category[i];
                // }
                // System.out.println("String values: " + values);
                
                // String[] properties = values.split("=");
                for(int j = 0; j < properties.length; j++) {
                    System.out.println("properties["+j+"] = " + properties[j]);
                }
            }
        }
        // else if(!root.getChild().isEmpty()) {
        //     System.out.println("enter second");

        //     Node newNode = new Node(key, parent);
        //     TreeNode treeNewNode = new TreeNode(newNode);

        //     if(category!=null) {
        //         System.out.println("enter third");

        //         String[] values;
        //         for(int i = 0; i < category.length; i++) {
        //             values = category[i].split("=");
        //             System.out.println("values["+i+"] : " + category[i]);
        //         }
        //         //System.out.println("values length: " + values.length);
        //     }
        // }
    }

    public TreeNode find(String inKey) {
        TreeNode foundNode = null;
        if(root.isEmpty()) {
            System.out.println("Tree is empty!");
        }
        else if(root.getKey().equals(inKey)) {
            foundNode = root;
        }
        else {
            foundNode = findRecursive(root, inKey);
        }
        return foundNode;
    }

    public TreeNode findRecursive(TreeNode startNode, String name) {
        TreeNode foundNode = null;
        for(int i = 0; i < startNode.getChildSize(); i++) {
            if(startNode.getChild().get(i).equals(name)) {
                foundNode = foundNode.getChild().get(i);
            }
            else if(!startNode.getChild().get(i).getChild().isEmpty()){
                if(foundNode != null) {
                    return foundNode;
                }
                foundNode = findRecursive(startNode.getChild().get(i), name);
            }
        }

        return foundNode;
    }

}

