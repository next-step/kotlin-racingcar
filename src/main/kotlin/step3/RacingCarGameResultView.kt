package step3

class RacingCarGameResultView {

    companion object {
        const val RESULT_TITLE = "실행 결과"
        const val OUTPUT_CHARACTER = "-"
    }

    fun print(racingCarDriveResults: List<RacingCarDriveResult>, totalRound: Long) {
        val roundDriveResultMap = racingCarDriveResults.groupBy { it.round }

        println(RESULT_TITLE)

        for(round in RacingCarGame.START_ROUND .. totalRound) {
            val carDriveResults = roundDriveResultMap[round]

            carDriveResults?.sortedBy { it.carNumber }?.forEach {
                repeat(it.position.toInt()) {
                    print(OUTPUT_CHARACTER)
                }
                println()
            }

            if (round < totalRound) {
                println()
            }
        }
    }
}
