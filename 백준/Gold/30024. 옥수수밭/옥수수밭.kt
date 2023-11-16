import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val map = Array(N) { IntArray(M) }
    val visited = Array(N) { BooleanArray(M) }

    val pq = PriorityQueue<Node>()

    for (i in 0 until N) {
        st = StringTokenizer(readLine());
        for (j in 0 until M) {
            val num = st.nextToken().toInt()
            map[i][j] = num
            if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                pq.offer(Node(j, i, map[i][j]))
                visited[i][j] = true
            }
        }
    }

    val K = readLine().toInt()

    fun BFS(): String {
        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, -1, 0, 1)

        val sb = StringBuilder()

        repeat(K) {
            val cn = pq.poll()

            sb.append(cn.y + 1).append(' ').append(cn.x + 1).append('\n')

            repeat(4) { it ->
                val nx = cn.x + dx[it]
                val ny = cn.y + dy[it]

                if (ny in 0 until N && nx in 0 until M) {
                    if (visited[ny][nx].not()) {
                        visited[ny][nx] = true
                        pq.offer(Node(nx, ny, map[ny][nx]))
                    }
                }
            }
        }

        return sb.toString()
    }

    val result = BFS()
    println(result)
}

private data class Node(val x:Int, val y:Int, val cnt:Int) : Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return other.cnt - cnt
    }
}