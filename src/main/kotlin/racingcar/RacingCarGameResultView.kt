package racingcar

class RacingCarGameResultView {

    fun print(gameResult: RacingCarGameResult, totalRound: Long) {
        println()
        println(RESULT_TITLE)

        val racingCarRoundResult = gameResult.gameRoundResults

        racingCarRoundResult.sortedBy { it.round }.forEach { roundResult ->
            roundResult.carDriveResults.sortedBy { it.carNumber }.forEach {
                print("${it.carName} : ")
                repeat(it.position.toInt()) {
                    print(OUTPUT_CHARACTER)
                }
                println()
            }

            if (roundResult.round < totalRound) {
                println()
            }
        }

        printGameWinners(winnerNames = gameResult.winnerNames)
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
