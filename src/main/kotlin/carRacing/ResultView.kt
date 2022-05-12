package carRacing

object ResultView {

    fun printTitle() {
        println("실행 결과")
    }

    fun printResultRecord(recordList: List<Record>) {
        recordList.forEach { record ->
            record.positions.forEach {
                val char = "_".repeat(it)
                println(char)
            }
            println()
        }
    }
}
