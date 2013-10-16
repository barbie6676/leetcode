// return the inorder successor node (the next node which value is bigger than the current node)

public successor (TreeNode e) {
  if (e == null) return null;
  
  if (e.parent == null || e.right != null) {
    if (e.right == null) return null;
    TreeNode left = e.right;
    //return the leftmost child of the right node.
    while (left != null) {
      left = left.left;
    }
    return left;
  } else {
    TreeNode parent = e.parent;
    while (parent != null) {
      if (parent.left == e) return parent;
      e = parent;
    }
    return parent;
  }

}
