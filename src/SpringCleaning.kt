fun main(args: Array<String>) {
    springcleaning()
}

inline fun springcleaning(){
    val t = Integer.parseInt(readLine())
    repeat(t){
        val list = readLine()!!.split(" ").map(String::toInt)
        val (n, k, x, y) = list
        var test = readLine()!!.split(" ").map(String::toInt)
        var bookshelf: MutableList<Int> = test.toMutableList()
        var answer:Int = 0

        while(!bookshelf.equals(bookshelf.filter { it <= k })){
            if (bookshelf.filter{ it > k}.size * x <= y){
                //k以上の値を取り除く回数 * x秒がy秒以下なら取り除いたほうが速い
                answer += bookshelf.filter{ it > k }.size * x
                break
            } else if(bookshelf.sum() <= k * bookshelf.size){
                //平均値がk以下の場合分配だけでOK
                if(bookshelf.sum() % bookshelf.size == 0){
                    //合計が割り切れる場合(平均値=k)、kを代入
                    answer += y
                    break
                } else {
                    bookshelf.forEachIndexed {
                        index, book ->
                        bookshelf[index] = k / bookshelf.size - index
                    }
                }
                answer += y
            } else {
                val i = bookshelf.indexOf(bookshelf.filter{ it > k}.reversed().first())
                bookshelf[i] = 0
                answer += x
            }
        }
        println(answer)
    }
}
