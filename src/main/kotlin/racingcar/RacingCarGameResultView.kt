package racingcar

class RacingCarGameResultView {

    fun print(gameResult: RacingCarGameResult, totalRound: Long) {
        println()
        println(RESULT_TITLE)

        printRoundResults(gameResult, totalRound)

        printGameWinners(winnerNames = gameResult.winnerNames)
    }

    private fun printRoundResults(gameResult: RacingCarGameResult, totalRound: Long) {
        val racingCarRoundResult = gameResult.gameRoundResults

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

    private fun printGameWinners(winnerNames: List<String>) {
        val result = winnerNames.joinToString(separator = ", ")
        println()
        println("$result 가 최종 우승했습니다.")
    }

    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val OUTPUT_CHARACTER = "-"
    }
}
