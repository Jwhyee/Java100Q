import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, d) = readLine().split(" ").map { it.toInt() }
    val shortCutList = ArrayList<Triple<Int, Int, Int>>()

    repeat(n) {
        val st = StringTokenizer(readLine())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        val cost = st.nextToken().toInt()

        if(d >= end && end - start > cost)
            shortCutList += Triple(start, end, cost)
    }

    shortCutList.sortWith(compareBy<Triple<Int, Int, Int>> {it.first}
        .thenByDescending { it.second }
        .thenBy { it.third }
    )

    var md = 0
    var idx = 0
    val distanceArr = IntArray(10001) { Int.MAX_VALUE }
    distanceArr[0] = 0

    while (md < d) {
        if (idx < shortCutList.size) {
            val shortCut = shortCutList[idx]
            if (md == shortCut.first) {
                distanceArr[shortCut.second] = min(distanceArr[md] + shortCut.third, distanceArr[shortCut.second])
                idx++
            } else {
                distanceArr[md + 1] = min(distanceArr[md + 1], distanceArr[md] + 1)
                md++
            }
        } else {
            distanceArr[md + 1] = min(distanceArr[md + 1], distanceArr[md] + 1)
            md++
        }
    }

    println(distanceArr[md])


}