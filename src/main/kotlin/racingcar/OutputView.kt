package racingcar

object OutputView {
    fun writeResult(result: RaceResult) {
        println("실행 결과")
        result.forEach {
            it.value.forEach { record -> println("${record.name} : ${"-".repeat(record.position.value)}") }
            println()
        }
    }

    fun writeError(e: Exception) {
        println(e.message)
    }
}
