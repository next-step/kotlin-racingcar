package racingcar.view

object RacingCarResultView {
    fun printResult(result: RacingCarResultDto) {
        println()
        println("실행 결과")

        result.resultPerRound.forEach { roundResult ->
            roundResult.forEachIndexed { index, position ->
                printPosition(result.carNames[index], position)
            }
            println()
        }

        printWinners(result.winners)
    }

    private fun printPosition(name: String, position: Int) {
        println("$name : " + "-".repeat(position))
    }

    private fun printWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }
}
