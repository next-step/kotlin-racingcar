package racingcar

object RacingCarOutputView {

    fun output(racingResults : RacingResults) {
        for(i in racingResults.values.indices) {
            println("라운드 - [${racingResults.values[i].round}] 결과")
            racingResults.values[i].distancesMoved.forEach() {
                println(it)
            }
            println()
        }
        println("====== 경주 종료 ======")
    }
}
