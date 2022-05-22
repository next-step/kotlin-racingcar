package racingcar

object RacingCarOutputView {

    fun output(racingResults : RacingResults) {
        for(i in racingResults.value.indices) {
            outputRacingResult(racingResults.value[i])
            println()
        }
        println("====== 경주 종료 ======")
    }

    private fun outputRacingResult(racingResult: RacingResult) {
        println("라운드 - [${racingResult.round}] 결과")
        racingResult.distancesMoved.forEach() {
            println(MOVED_SYMBOL.repeat(it))
        }
    }

    private const val MOVED_SYMBOL = "-"
}
