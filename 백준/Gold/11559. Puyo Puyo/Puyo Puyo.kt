import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Queue
import java.util.LinkedList

private const val n = 12
private const val m = 6
private val map = Array(n) { CharArray(m) }
private val queue: Queue<Pair<Int, Int>> = LinkedList()
private var visited = Array(n) { BooleanArray(m) }

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    repeat(n) { y ->
        map[y] = readLine().toCharArray()
    }

    var chainingCount = 0
    while (true) {
        visited = Array(n) { BooleanArray(m) }

        var isPop = false
        for (y in (n - 1) downTo 0) {
            for (x in 0 until m) {
                val cur = map[y][x]
                if (cur != '.') {
                    queue.clear()
                    val bubbleCnt = dfs(y, x, 1, cur)
                    if (bubbleCnt >= 4) {
                        isPop = true
                        doPop()
                    }
                }
            }
        }
        if (isPop) {
            chainingCount++
            for (x in 0 until m) {
                downBubble(x)
            }
        } else {
            break
        }
    }
    println(chainingCount)
}

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun downBubble(x: Int) {
    for (y in (n - 2) downTo 0) {
        val cur = map[y][x]
        if (cur != '.') {
            downDfs(y, x, cur)
        }
    }
}

fun downDfs(y: Int, x: Int, c: Char) {
    val ny = y + 1
    if (ny in 0 until n && map[ny][x] == '.') {
        map[y][x] = '.'
        map[ny][x] = c
        downDfs(ny, x, c)
    }
}

fun doPop() {
    while (queue.isNotEmpty()) {
        val cur = queue.poll()
        map[cur.first][cur.second] = '.'
    }
}

fun dfs(y: Int, x: Int, cnt: Int, color: Char): Int {
    var count = cnt
    visited[y][x] = true
    queue += (y to x)

    for (i in 0..3) {
        val (ny, nx) = y + dy[i] to x + dx[i]
        if (ny in 0 until n && nx in 0 until m) {
            if (visited[ny][nx].not() && map[ny][nx] == color) {
                count = dfs(ny, nx, count + 1, color)
            }
        }
    }
    return count
}