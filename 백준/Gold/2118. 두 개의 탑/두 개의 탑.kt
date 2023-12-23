val br = System.`in`.bufferedReader()
fun getInt() = br.readLine().toInt()
lateinit var preSum: IntArray
fun main() = with(System.out.bufferedWriter()) {
    val n = getInt()
    preSum = IntArray(n+1)
    for(i in 1 .. n){
        preSum[i] = preSum[i-1] + getInt()
    }
    var answer = 0
    for(i in 1 .. n){
        var s = i
        var e = n
        while(s<=e){
            val mid = (s+e)/2
            val originDis = preSum[mid] - preSum[i-1]
            val reverseDis = preSum[n] - originDis
            val minDis = originDis.coerceAtMost(reverseDis)
            answer = answer.coerceAtLeast(minDis)
            if(originDis < reverseDis){
                s= mid+1
            }
            else{
                e = mid-1
            }
        }
    }
    write("$answer")
    close()
}