class TNode{
    int data;
    TNode left;
    TNode right;
    public TNode(int data) {
        this.data = data;
    }
}

class BST{
    TNode root;
    public BST (int data){
        root = new TNode(data);
    }

    public void  insert(int data){
        insert(root, data);
    }

    public TNode insert(TNode root, int data){
        if(root== null){ // This will call for each element creation
            return new TNode(data);
        }
        if(data < root.data){ // If the passed data less than the root data new node will create in left side
            root.left = insert(root.left, data);
        } else{ // If the passed data less than the root data new node will create in right side
            root.right = insert(root.right, data);
        }
        return root;
    }

    public void traveseInOrder(TNode root){
        if(root == null){ // This will check the stack if pointer reached the last note it will go back
            return;
        } else{
            traveseInOrder(root.left);
            System.out.println(root.data);
            traveseInOrder(root.right);
        }
    }

    public void search(TNode node, int data){
        if(node == null){// If the tree empty it will print
            System.out.println("Element/node not found.." + data);
            return;
        }
        if(data == node.data){ // If searching data found it will print and exit
            System.out.println("Element/node found.." +  data);
            return;
        } else if (data < node.data) { //if searching data is less than node data recursively call and goes left
            search(node.left, data);
        } else{ // //if searching data is greater than node data recursively call and goes right
            search(node.right, data);
        }
    }

    public int findMin(TNode node){
        if (node == null) // If the tree empty it will print
            System.out.println("Tree not found....");
        else if(node.left == null) // If there are no left pointer then the node is left leaf node it will return the node data
            return node.data;
        return findMin(node.left); // Recursively call the same method with left ref
    }

    public int findMax(TNode node){
        if(node == null) {
            System.out.println("Tree not found ..");
        } else if(node.right == null){ // If there are no left ref then the node is right leaf node it will return the node data
            return node.data;
        }
        return findMax(node.right); // Recursively call the same method with right ref
    }

    public TNode deleteNode(TNode node, int data){
        if(node == null){  // If there is no data in tree it says node not found
            System.out.println("Node not found");
            return node;
        }
        if(data < node.data){ // if data less than root it will call tree recursively and traverse left
            node.left = deleteNode(node.left, data);
        }
        else if(data > node.data){ // if data greater than root it will call tree recursively and traverse right
            node.right = deleteNode(node.right, data);
        }

        else{ // if data is equal which means its found the actual node; position found
            if (node.right == null)  // If the node has one child / no child; and it has no right node so delete left node
                return node.left; // Actually it will delete the left node
            else if(node.left == null) // If the node has one child / no child; and it has no left node so delete right node
                return node.right; // Actually it will delete the right node
            node.data = findMin(node.right); // if node has both sides the finds right side min value and set that value as root data
            node.right = deleteNode(node.right, node.data); // After setting the right min data, the existing node will be deleted here
        }
        return node;
    }

}

public class BinarySearchTree {
    public static void main(String[] args){
      BST bst = new BST(50);
      bst.insert(30);
      bst.insert(10);
      bst.insert(60);
      bst.insert(65);

      bst.traveseInOrder(bst.root);

      bst.search(bst.root, 30);
      bst.search(bst.root, 7);

      System.out.println("Min : " +  bst.findMin(bst.root));
      System.out.println("Max : " +  bst.findMax(bst.root));

      bst.deleteNode(bst.root, 100);
      System.out.println("Max : " +  bst.findMax(bst.root));
      bst.traveseInOrder(bst.root);
    }
}
