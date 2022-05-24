package racingcar

object RacingCarOutputView {

    fun output(racingResults: RacingResults) {
        for (i in racingResults.value.indices) {
            outputRacingResult(racingResults.value[i])
            println()
        }
        println("====== 경주 종료 ======")
        outputWinners(racingResults)
    }

    private fun outputWinners(racingResults: RacingResults) {
        println("${racingResults.winners().joinToString { it.name() }}가 최종 우승했습니다.")
    }

    private fun outputRacingResult(racingResult: RacingResult) {
        outputRacingRound(racingResult)
        outputRacingCarsInfo(racingResult)
    }

    private fun outputRacingCarsInfo(racingResult: RacingResult) {
        racingResult.carsResult().forEach() { carResult ->
            println("${carResult.name()} : ${MOVED_SYMBOL.repeat(carResult.distanceMoved)}")
        }
    }

    private fun outputRacingRound(racingResult: RacingResult) {
        println("라운드[${racingResult.round}] 결과")
    }

    private const val MOVED_SYMBOL = "-"
}
