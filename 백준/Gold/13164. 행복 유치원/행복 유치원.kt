import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(readLine())
    val arr = IntArray(n) { st.nextToken().toInt() }

    for (i in 0 until n - 1) {
        arr[i] = arr[i + 1] - arr[i]
    }

    arr.sort()

    val min = (0 until (n - 1) - (k - 1)).sumOf { i -> arr[i] }
    println(min)
}