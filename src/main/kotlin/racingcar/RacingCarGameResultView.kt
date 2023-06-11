package racingcar

class RacingCarGameResultView {

    fun print(racingCarRoundResult: List<RacingCarRoundResult>, totalRound: Long) {
        println()
        println(RESULT_TITLE)

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
    }

    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val OUTPUT_CHARACTER = "-"
    }
}
