package racingcar.view

class ResultView {
    fun printResult(result: List<String>) {
        result.forEach { println(it) }
        println()
    }

    fun printWinnersName(winnerNames: String) {
        println("$winnerNames 가 최종 우승했습니다." )
    }
}
