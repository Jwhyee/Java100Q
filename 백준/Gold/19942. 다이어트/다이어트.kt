import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

data class Nutrient(val p: Int, val f: Int, val c: Int, val v: Int, val price: Int)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val standards = readLine().split(" ").map { it.toInt() }.toIntArray()
    val visited = BooleanArray(N)
    val list = mutableListOf<Nutrient>()

    repeat(N) {
        val st = StringTokenizer(readLine())
        list += Nutrient(st.nextToken().toInt()
            , st.nextToken().toInt()
            , st.nextToken().toInt()
            , st.nextToken().toInt()
            , st.nextToken().toInt()
        )
    }

    val ml = mutableListOf<Int>()

    var min = Int.MAX_VALUE
    val result = mutableListOf<Int>()

    fun backtracking(depth: Int, pSum: Int, fSum: Int, cSum: Int, vSum: Int, priceSum: Int) {
        val cur = list[depth]
        val curPSum = pSum + cur.p
        val curFSum = fSum + cur.f
        val curCSum = cSum + cur.c
        val curVSum = vSum + cur.v
        val curPriceSum = priceSum + cur.price

        visited[depth] = true
        ml += depth

        if (curPriceSum >= min) {
            return
        }

        if (curPSum >= standards[0] && curFSum >= standards[1] && curCSum >= standards[2] && curVSum >= standards[3]) {
            result.clear()
            min = curPriceSum
            result += ml
            return
        } else {
            for (i in depth + 1 until list.size) {
                if (visited[i].not()) {
                    backtracking(i, curPSum, curFSum, curCSum, curVSum, curPriceSum)
                    ml.removeLast()
                    visited[i] = false
                }
            }
        }
    }

    for (i in list.indices) {
        ml.clear()
        visited.fill(false)

        backtracking(i, 0, 0, 0, 0, 0)
    }

    if (result.isEmpty()) {
        println(-1)
    } else {
        val bw = BufferedWriter(OutputStreamWriter(System.out))
        bw.append("$min").append('\n')
        result.forEach {
            bw.append("${it + 1} ")
        }
        bw.flush()
        bw.close()
    }
}