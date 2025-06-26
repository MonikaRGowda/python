public class bst
{
	static class node
	{
		int item;
		node left,right;
		public node(int item)
		{
			this.item=item;
			left=null;
			right=null;
		}
	}
	static node root;
	bst()
	{
		root=null;
	}
	static void insert(int key)
	{
		root=insertrec(key,root);
	}
	static node insertrec(int key,node root)
	{
		if(root==null)
		{
			root=new node(key);
			return root;
		}
		if(key<root.item)
			root.left=insertrec(key,root.left);
		else
			root.right=insertrec(key,root.right);
		return root;
	}
	static void delete(int key)
	{
		root=deleterec(key,root);
	}
	static node deleterec(int key,node root)
	{
		if(root==null)
			return root;
		if(key<root.item)
			root.left=deleterec(key,root.left);
		else if(key>root.item)
			root.right=deleterec(key,root.right);
		else
		{
			if(root.left==null)
				return root.right;
			else if(root.right==null)
				return root.left;
			else
			{
				root.item=minval(root.right);
				root.right=deleterec(root.item,root.right);
			}
		}
		return root;
	}
	static int minval(node root)
	{
		while(root.left!=null)
			root=root.left;
		return root.item;
	}
	static void inorder()
	{
		inorderrec(root);
	}
	static void inorderrec(node root)
	{
		if(root!=null)
		{
			inorderrec(root.left);
			System.out.print(root.item+" ");
			inorderrec(root.right);
		}
	}
	@SuppressWarnings("static-access")
	public static void main(String[] args)
	{
		bst tree=new bst();
		tree.insert(5);
		tree.insert(7);
		tree.insert(2);
		tree.insert(9);
		tree.insert(6);
		tree.insert(3);
		tree.insert(1);
		System.out.println("Tree traversal:");
		tree.inorder();
		System.out.println("after deleting 2:");
		tree.delete(2);
		tree.inorder();
	}
}