public class BinarySearchTree {
	private TreeNode root;
	private int total;
	public BinarySearchTree() {
		root = null;
		total = 0;
	}
	
	public void insert(Comparable next) {
		root = insertHelper( root, next );
	}
	
	private TreeNode insertHelper(TreeNode root, Comparable next) {
		if( root == null )
          root = new TreeNode( next, null, null );
      else if( next.compareTo( root.getValue() ) < 0 )
          root.setLeft(insertHelper( root.getLeft(), next));
      else if( next.compareTo( root.getValue() ) > 0 )
          root.setRight(insertHelper( root.getRight(), next));
      else { }
      return root;
	}
	
	public void printInOrder() {
		printInorderHelper( root );
	}
	
	private void printInorderHelper(TreeNode root) {
		if( root != null )
            {
                printInorderHelper( root.getLeft() );
                System.out.println( root.getValue() );
                printInorderHelper( root.getRight() );
            }
	}
	
	public int countNodes() {
		return countNodesHelper(root);
	}
	
	private int countNodesHelper(TreeNode root) {
		if( root != null )
            {
                countNodesHelper( root.getLeft());
                total++;
                countNodesHelper( root.getRight() );
            }
			return total;
	}
	
	public Object find(Comparable target) {
		if (findHelper(root, target) == null)
			return null;
		return findHelper(root, target).getValue();
	}
	
	private TreeNode findHelper(TreeNode root, Comparable target) {
		if( root == null )
                return null;
        if( target.compareTo( root.getValue() ) < 0 )
                return findHelper(  root.getLeft(), target );
            else if( target.compareTo( root.getValue() ) > 0 )
                return findHelper( root.getRight(), target );
            else
                return root;
	}
	
	public void delete(Comparable target) {
		root = deleteHelper(root, target);
	}
	
	private TreeNode deleteHelper(TreeNode node, Comparable target) {
		if( node == null )
                return null;
            if( target.compareTo( node.getValue() ) < 0 )
                node.setLeft(deleteHelper(node.getLeft(), target));
            else if( target.compareTo( node.getValue() ) > 0 )
                node.setRight(deleteHelper(node.getRight(), target));
            else if( node.getLeft() != null && node.getRight() != null ) {
                node.setValue(getMin( node.getRight() ).getValue());
                node.setRight(deleteHelper( node.getRight(), (Comparable)node.getValue()));
            }
            else
                return node;
            return node;
	}
	
	private TreeNode getMin( TreeNode node )
        {
            if( node == null )
                return null;
            else if( node.getLeft() == null )
                return node;
            return getMin(node.getLeft() );
        }
	
}
