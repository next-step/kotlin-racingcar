package carRacing

object ResultView {

    fun printTitle() {
        println("실행 결과")
    }

    fun printResultRecord(recordList: List<List<Int>>) {
        recordList.forEach { record ->
            record.forEach {
                val char = "_".repeat(it)
                println(char)
            }
            println()
        }
    }
}
