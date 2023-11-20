package ps.impl

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque
import java.util.StringTokenizer
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val map = Array(N) { IntArray(N) }

    val K = readLine().toInt()
    repeat(K) {
        val st = StringTokenizer(readLine())
        val y = st.nextToken().toInt() - 1
        val x = st.nextToken().toInt() - 1
        map[y][x] = -1
    }

    val L = readLine().toInt()
    val turnList:Queue<Pair<Int, String>> = LinkedList()
    repeat(L) {
        val st = StringTokenizer(readLine())
        turnList += Pair(st.nextToken().toInt(), st.nextToken())
    }

    val dy = intArrayOf(-1, 0, 1, 0)
    val dx = intArrayOf(0, 1, 0, -1)

    var dir = 1
    var time = 0

    val snake = ArrayDeque<Pair<Int, Int>>()
    snake.addFirst(0 to 0)

    fun isPossible(x: Int, y: Int): Boolean = (x in 0 until N && y in 0 until N)
    fun isApple(x: Int, y: Int): Boolean = map[y][x] == -1

    while (true) {
        val ny = snake.peekFirst().first + dy[dir]
        val nx = snake.peekFirst().second + dx[dir]

        snake.addFirst(Pair(ny, nx))
        val cur = snake.peekFirst()

        if(!isPossible(cur.second, cur.first)) break
        if(map[ny][nx] == 1) break

        if (!isApple(nx, ny)) {
            val tail = snake.pollLast()
            map[tail.first][tail.second] = 0
        }

        map[ny][nx] = 1

        time++

        turnList.peek()?.let {
            if(it.first == time) {
                dir = when(it.second) {
                    "L" -> (dir + 3) % 4
                    "D" -> (dir + 1) % 4
                    else -> 0
                }
                turnList.poll()
            }
        }
    }

    println(++time)

}