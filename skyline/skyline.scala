//https://leetcode.com/problems/max-increase-to-keep-city-skyline/
object App {
  def max(a:Int, b:Int) = if( a > b) a else b
    def min(a:Int, b:Int) = if( a < b) a else b
    def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    var sum = 0
    for( i <- grid.indices) {
      for( j <- grid.indices) {
        var maxRow = 0
        var maxCol = 0

        for(k <- grid.indices)
          maxRow = max(maxRow, grid(i)(k))
        for(k <- grid.indices)
          maxCol = max(maxCol, grid(k)(j))
          
        sum = sum + (min(maxCol, maxRow)  - grid(i)(j))
      }
    }
    return sum
  }
  def main(args: Array[String]): Unit = {
    val str = "[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]"
    val grid =  str.slice(0, str.length - 1).split(']').map( s => s.slice(2,s.length)).map( s => s.split(',').map(_.toInt))
    println(maxIncreaseKeepingSkyline(grid))

  }
}