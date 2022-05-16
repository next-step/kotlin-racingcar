package racingcar

object RacingCarOutputView {

    fun output(racingResults : RacingResults) {
        for(i in racingResults.value.indices) {
            outputRoundInfo(racingResults.value[i].round)
            outputRacingResult(racingResults.value[i])
            println()
        }
        println("====== 경주 종료 ======")
    }

    private fun outputRoundInfo(round: Int) {
        println("라운드 - [$round] 결과")
    }

    private fun outputRacingResult(racingResult: RacingResult) {
        racingResult.distancesMoved.forEach() {
            println(MOVED_SYMBOL.repeat(it))
        }
    }

    private const val MOVED_SYMBOL = "-"
}
