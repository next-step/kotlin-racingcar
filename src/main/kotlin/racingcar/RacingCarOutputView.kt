package racingcar

object RacingCarOutputView {

    fun output(racingResults : RacingResults) {
        for(i in racingResults.value.indices) {
            println("라운드 - [${racingResults.value[i].round}] 결과")
            racingResults.value[i].distancesMoved.forEach() {
                println(MOVED_SYMBOL.repeat(it))
            }
            println()
        }
        println("====== 경주 종료 ======")
    }

    private const val MOVED_SYMBOL = "-"
}
