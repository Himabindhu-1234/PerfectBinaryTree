package JavaPBT;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

 

class BTNode
{
BTNode left, right;
int data;


 /* Constructor */
public BTNode()
{
left = null;
right = null;
data = 0;
}
/* Constructor */
public BTNode(int n)
{
left = null;
right = null;
data = n;
}
/* Function to set left node */
public void setLeft(BTNode n)
{
left = n;
}
/* Function to set right node */
public void setRight(BTNode n)
{
right = n;
}
/* Function to get left node */
public BTNode getLeft()
{
return left;
}
/* Function to get right node */
public BTNode getRight()
{
return right;
}
/* Function to set data to node */
public void setData(int d)
{
data = d;
}
/* Function to get data from node */
public int getData()
{
return data;
}
}

/* Class BT */
class BT
{
private static BTNode root;

 /* Constructor */
public BT()
{
root = null;
}
/* Function to check if tree is empty */
public boolean isEmpty()
{
return root == null;
}
/* Functions to insert data */
public void insert(int data)
{
root = insert(root, data);
}
/* Function to insert data recursively */
private BTNode insert(BTNode node, int data)
{
String a = "r";
String b = "l";

if (node == null)
node = new BTNode(data);
else
{
Scanner scan = new Scanner(System.in);
System.out.println("Enter L for left and R for right : ");
String type = scan.nextLine();
{
if (a.equals(type)) {
node.right = insert(node.right, data);}
else if (b.equals(type))
{
node.left = insert(node.left, data);
}}}
return node;
}
public void postorder()
{
postorder(root);
}
private void postorder(BTNode r)
{
if (r != null)
{
postorder(r.getLeft());
postorder(r.getRight());
System.out.print(r.getData() +" ");
}
}
static boolean CheckPerfectTree(BTNode root)
{
Queue<BTNode> q = new LinkedList<BTNode>();
// add the root node
q.add(root);
// Flag to check if leaf nodes have been found
int flag = 0;
while (q.size() > 0)
{
BTNode temp = q.peek();
q.remove();
// If current node has both left and right child
if (temp.left != null && temp.right != null)
{
// If a leaf node has already been found
// then return false
if (flag == 1)
return false;
// If a leaf node has not been discovered yet
// add the left and right child in the queue
else
{
q.add(temp.left);
q.add(temp.right);
}
}
// If a leaf node is found mark flag as one
else if (temp.left == null && temp.right == null)
{
flag = 1;
}
// If the current node has only one child
// then return false
else if (temp.left == null || temp.right == null)
return false;
}
// If the given tree is perfect return true
return true;
}
public static void main(String[] args)
{

Scanner scan = new Scanner(System.in);
/* Creating object of BT */
BT bt = new BT();
/* Perform tree operations */
System.out.println("Perfect Binary Tree Test");

int n = 0;
System.out.print("Enter number of nodes : ");
n = scan.nextInt();
for (int i = 0; i < n ; i++)
{
System.out.println("\nEnter integer element to insert :");
bt.insert( scan.nextInt() );
System.out.print("Order : ");
bt.postorder();

}
if (CheckPerfectTree(root))
System.out.printf("\nYes, It is a perfect Binary tree!");
else
System.out.printf("\nNo, it is not a perfect Binary tree!");
}
}
