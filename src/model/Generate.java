package Assignment.model;
import java.util.*;

public class Generate {
    private Random rand = new Random();
    private String outputFile;
    private double dm, da, de, em, ea, ee, h, s;
    private TreeNode root = null;
    private List<String> treeKeysArray = new ArrayList<String>();
    private int treeLength = random.nextInt(10);
    
    public Generate() {}

    public void generateTreeNode() {
        
        for(int i = 0; i < treeLength; i++) {
            if(root == null) {
                String randomKeyName = randomKey();
                Node newNode = new Node(randomKeyName, randomKeyName);
                TreeNode treeNewNode = new TreeNode(newNode);
                root = newNode;
            }
            
            if(root!=null) {
    
                if(treeKeysArray.size() == 2) {
                    String randomKeyName = randomKey();
                    Node newNode = new Node(randomKeyName, root);
                    TreeNode treeNewNode = new TreeNode(newNode);
                }
    
                if(treeKeysArray.size() > 2) {
                    int modeToAddChild = (int) (Math.random()); // will return either 0 or 1 , 0 = addChild, 1 = not addChild
                    String randomKeyName = randomKey();
                    String randomParent = randomKey();
                    randomParent = treeKeysArray.get(getRandomKeyFromList);
                    Node newNode = new Node(randomKeyName, randomParent);
                    TreeNode treeNewNode = new TreeNode(newNode);
                }
    
                // if(treeKeysArray.size() > 2) {
                //     String randomKeyName = randomKey();
                //     String randomParent = treeKeysArray.get(getRandomKeyFromList);
                //     Node newNode = new Node(randomKeyName, randomParent);
                //     TreeNode treeNewNode = new TreeNode(newNode);
                //     TreeNode parentNode = find(randomParent);
                //     parentNode.addChild(parentNode, treeNewNode);
                // }
            }
        }
        
    }


    public String randomKey() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz" + "0123456789";
        int length = rand.nextInt(10);
        StringBuilder sb = new StringBuilder(length);
        
        for(int i = 0; i<length; i++) {
            int index = (int) (alphabet.length() * Math.random());
            sb.append(alphabet.charAt(index));
        }
        treeKeysArray.add(sb.toString());
        return sb.toString();
    }

    public int getRandomKeyFromList() {
        return treeKeysArray.get(rand.nextInt(treeKeysArray.size()));
    }
}
