package racingcar

object OutputView {
    fun writeResult(result: RaceResult) {
        println("실행 결과")
        result.records
            .groupBy { it.round }
            .forEach {
                it.value.forEach { record -> println("${record.name} : ${"-".repeat(record.position.value)}") }
                println()
            }
    }

    fun writeWinner(winner: Winner) {
        println("${winner.names().joinToString(", ")}가 최종 우승했습니다.")
    }

    fun writeError(e: Exception) {
        println(e.message)
    }
}
