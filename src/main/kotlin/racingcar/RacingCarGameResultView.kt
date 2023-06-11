package racingcar

class RacingCarGameResultView {

    fun print(gameResult: List<RacingCarRoundResult>, totalRound: Long) {
        println()
        println(RESULT_TITLE)

        printRoundResults(racingCarRoundResult = gameResult, totalRound = totalRound)

        printGameWinners(racingCarRoundResult = gameResult, lastRound = totalRound)
    }

    private fun printRoundResults(racingCarRoundResult: List<RacingCarRoundResult>, totalRound: Long) {
        racingCarRoundResult.sortedBy { it.round }.forEach { roundResult ->
            printRoundResult(roundResult, totalRound)
        }
    }

    private fun printRoundResult(roundResult: RacingCarRoundResult, totalRound: Long) {
        roundResult.carDriveResults.sortedBy { it.carNumber }.forEach {
            printCarRoundResult(it)
        }

        printRoundResultLastLine(roundResult, totalRound)
    }

    private fun printRoundResultLastLine(roundResult: RacingCarRoundResult, totalRound: Long) {
        if (roundResult.round < totalRound) {
            println()
        }
    }

    private fun printCarRoundResult(result: RacingCarDriveResult) {
        print("${result.carName} : ")
        repeat(result.position.toInt()) {
            print(OUTPUT_CHARACTER)
        }
        println()
    }

    private fun printGameWinners(racingCarRoundResult: List<RacingCarRoundResult>, lastRound: Long) {
        val winnerNames = RacingCarGameWinnerFinder.findWinnerNames(racingCarRoundResult, lastRound)
        val result = winnerNames.joinToString(separator = ", ")

        println()
        println("$result 가 최종 우승했습니다.")
    }

    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val OUTPUT_CHARACTER = "-"
    }
}
