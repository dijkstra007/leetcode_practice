//https://leetcode.com/problems/max-increase-to-keep-city-skyline/
object App {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    var new_gird = grid.clone()
    var sum = 0
    for( i <- grid.indices) {
      for( j <- grid.indices) {
        var row = Array[Int]()
        var col = Array[Int]()

        for(k <- grid.indices)
          row = row :+ grid(i)(k)
        for(k <- grid.indices)
          col = col :+ grid(k)(j)

        sum = sum + (Array(row.max, col.max).min  - grid(i)(j))
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