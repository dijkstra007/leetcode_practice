//https://leetcode.com/problems/range-sum-of-bst/
class TreeNode(var _value:Int ) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
  def insert(tree:TreeNode, x: Int): TreeNode = {
    if(tree.left != null && x < tree.value) {
      insert(tree.left, x)
    }
    else if(x < tree.value) {
      tree.left = new TreeNode(x)
    }
    else if(tree.right != null && x > tree.value) {
      insert(tree.right, x)
    }
    else if(x > tree.value) {
      tree.right = new TreeNode(x)
    }
    tree
  }

  def insert(x: Int): TreeNode = {
    insert(this, x)
  }

  def insert(arr: Array[Int]): TreeNode = {
    arr.foreach( elem => this.insert(this, elem))
    this
  }

  def printTree(tree: TreeNode): Unit = {
      if(tree != null ) {
        println(tree.value)
        printTree(tree.left)
        printTree(tree.right)
      }
  }

  def printTree : Unit = {
    printTree(this)
  }
}


object App {
  def rangeSumBST(root: TreeNode, L: Int, R: Int): Int = {
      var sum = 0
      def treeTravel(tree: TreeNode) : Unit = {
          if(tree != null) {
            if(L to R contains tree.value){
              sum = sum + tree.value
            }
            treeTravel(tree.left)
            treeTravel(tree.right)
          }
      }
      treeTravel(root)
      sum
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(10)
    root.insert(Array(5,3,7,15,16))
    root.printTree
    println(rangeSumBST(root, 7, 15))

  }
}