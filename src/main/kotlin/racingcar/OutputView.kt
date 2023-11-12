package racingcar

object OutputView {

    fun printResultTitle() {
        println("실행 결과")
    }

    fun printResult(result: List<Car>) {
        result.forEach {
            println("-".repeat(it.position))
        }
        println()
    }

    fun printWinners(winners: List<Car>) {
        val winnerNames = winners.joinToString(", ") { it.name }
        println("$winnerNames 가 최종 우승했습니다.")
    }
}
