package racingcar.view

object RacingCarResultView {
    fun printResult(result: RacingCarResultDto) {
        println()
        println("실행 결과")

        result.resultPerRound
            .forEach { roundResult ->
                printRoundResult(result.carNames, roundResult)
                println()
            }

        printWinners(result.winners)
    }

    private fun printRoundResult(carNames: List<String>, roundResult: List<Int>) {
        roundResult.forEachIndexed { index, position ->
            printPosition(carNames[index], position)
        }
    }

    private fun printPosition(name: String, position: Int) {
        println("$name : " + "-".repeat(position))
    }

    private fun printWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }
}
