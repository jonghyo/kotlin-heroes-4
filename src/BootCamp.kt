fun main(args: Array<String>) {
    bootcamp()
}

inline fun bootcamp(){
    val t = Integer.parseInt(readLine())
    repeat(t){
        val list = readLine()!!.split(" ").map(String::toInt)
        val (n,k1,k2) = list
        val s:String = readLine()!!
        var lecturers = arrayListOf<Int>()

        s.forEachIndexed { index,c ->
            when(c){
                '0' -> lecturers.add(0)
                '1' -> if(index == 0){
                    //sの1文字目が1
                    lecturers.add(k1)
                } else if(lecturers[index-1] == 0){
                    //前日が休み(c = 0)
                    lecturers.add(k1)
                } else if(lecturers[index-1] == k1){
                    //前日k1分講義実施
                    if(k2-k1 < k1){
                        lecturers.add(k2-k1)
                    } else {
                        lecturers.add(k1)
                    }
                } else {
                    //前日k2-k1分講義実施(sが111みたいな状況)
                    lecturers.add(k1)
                }
            }
        }

        println(lecturers.sum())
    }
}
