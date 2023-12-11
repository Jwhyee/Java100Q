import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

val cnt = Array(101) { 0 }
val ladder = Array(101) { 0 }
val visited = Array(101) { false }
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    for (i in 0 until n + m) {
        st = StringTokenizer(readLine())
        ladder[st.nextToken().toInt()] = st.nextToken().toInt()
    }

    bfs()
}

fun bfs() {
    val queue: Queue<Int> = LinkedList()
    queue += 1
    cnt[1] = 0
    visited[1] = true
    while (!queue.isEmpty()) {
        val cur = queue.poll()
        if (cur == 100) {
            println(cnt[cur])
            return
        }
        for (i in 1 .. 6) {
            val np = cur + i
            if (100 < np || visited[np]) continue
            visited[np] = true
            if (ladder[np] != 0) {
                if (!visited[ladder[np]]) {
                    queue += ladder[np]
                    visited[ladder[np]] = true
                    cnt[ladder[np]] = cnt[cur] + 1
                }
            }
            else {
                queue += np
                cnt[np] = cnt[cur] + 1
            }
        }
    }
}