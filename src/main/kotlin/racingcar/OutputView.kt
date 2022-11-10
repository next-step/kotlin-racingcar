package racingcar

object OutputView {
    fun writeResult(result: Map<Int, List<Record>>) {
        println("실행 결과")
        result.forEach {
            it.value.forEach { record -> println("-".repeat(record.position.value)) }
            println()
        }
    }

    fun writeError(e: Exception) {
        println(e.message)
    }
}
