import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine().toInt()

    val map = HashMap<String, Boolean>()

    repeat(n) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val status = st.nextToken()

        map[name] = status == "enter"
    }

    map.keys.sortedDescending().forEach {
        if(map[it]!!) bw.append(it).append('\n')
    }

    bw.flush()
    bw.close()
    br.close()

}