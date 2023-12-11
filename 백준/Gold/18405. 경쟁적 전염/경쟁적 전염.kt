import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val K = st.nextToken().toInt()

    val map = Array(N) { IntArray(N) }

    val pq = PriorityQueue<Triple<Int, Int, Int>> { a, b -> a.third - b.third }

    for (i in 0 until N) {
        st = StringTokenizer(readLine())
        for (j in 0 until N) {
            map[i][j] = st.nextToken().toInt()
            val num = map[i][j]
            if (num != 0) {
                pq.add( Triple(i, j, num) )
            }
        }
    }


    st = StringTokenizer(readLine())
    var s = st.nextToken().toInt()
    val x = st.nextToken().toInt()
    val y = st.nextToken().toInt()

    var time = 0

    val dy = arrayOf(0, 1, 0, -1)
    val dx = arrayOf(1, 0, -1, 0)

    while (s-- > 0) {
        val temp = LinkedList<Triple<Int, Int, Int>>()

        while (!pq.isEmpty()) {
            val cur = pq.poll()

            for (i in 0..3) {
                val nx = cur.second + dx[i]
                val ny = cur.first + dy[i]

                if (nx in 0 until N && ny in 0 until N) {
                    if (map[ny][nx] == 0) {
                        map[ny][nx] = cur.third
                        temp.add(Triple(ny, nx, cur.third))
                    }
                }
            }
        }
        pq.addAll(temp)
    }

    println(map[x - 1][y - 1])

}