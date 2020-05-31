fun main(args: Array<String>) {
    val t = Integer.parseInt(readLine())
    repeat(t){
        val list = readLine()!!.split(" ").map(String::toInt)
        val (n, k) = list
        val n1:Int = (n / (1 + k + Math.pow(k.toDouble(), 2.0).toInt() + Math.pow(k.toDouble(), 3.0).toInt())).toInt()
        val n2 = n1 * k
        val n3 = n2 * k
        val n4 = n3 * k
        println("${n1} ${n2} ${n3} ${n4}")
    }
}
