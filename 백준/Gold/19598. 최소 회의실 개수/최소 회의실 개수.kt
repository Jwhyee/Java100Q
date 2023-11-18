import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    repeat(N) {
        val st = StringTokenizer(readLine())
        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()
        list += Pair(first, second)
    }
    list.sortBy { it.first }
    val pq = PriorityQueue<Pair<Int, Int>> { a, b -> a.second - b.second }
    val firstPair = list[0]
    pq.offer(firstPair)

    for (i in 1 until N) {
        val prev = pq.peek()
        val next = list[i]

        if (prev.second <= next.first) {
            pq.poll()
        }
        pq.offer(next)
    }
    println(pq.size)

}