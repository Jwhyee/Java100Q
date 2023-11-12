import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var N:Int = 0
var M:Int = 0

val dx = arrayOf(1, 0, -1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())

    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    val map = Array(N) { IntArray(M) }
    val visited = Array(N) { BooleanArray(M) }

    for (y in 0 until N) {
        st = StringTokenizer(readLine())
        for (x in 0 until M) {
            map[y][x] = st.nextToken().toInt()
        }
    }


    var time = 0

    loop@while (true) {
        val air = Array(N) { BooleanArray(M) }
        airCheck(map, air, 0, 0)

        for (y in 0 until N) {
            for (x in 0 until M) {
                if(map[y][x] == 1 && visited[y][x].not())
                    dfs(map, visited, air, y, x)
            }
        }

        var cnt = 0
        for (i in 0 until N) {
            if(false in air[i]) cnt++
        }

        if(cnt == 0) break@loop
        time++

    }

    println(time)

}

fun checkRange(y: Int, x: Int): Boolean {
    return y in 0 until N && x in 0 until M
}

fun dfs(
    map: Array<IntArray>,
    visited: Array<BooleanArray>,
    air: Array<BooleanArray>,
    y: Int,
    x: Int
) {
    var cnt = 0
    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (checkRange(ny, nx)) {
            if (air[ny][nx]) {
                cnt++
            }
        }
    }

    if (cnt >= 2) {
        visited[y][x] = true
        map[y][x] = 0
    }

}

fun airCheck(map: Array<IntArray>, air: Array<BooleanArray>, y: Int, x: Int) {
    air[y][x] = true

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if (checkRange(ny, nx)) {
            if (map[ny][nx] == 0 && air[ny][nx].not()) {
                airCheck(map, air, ny, nx)
            }
        }
    }
}