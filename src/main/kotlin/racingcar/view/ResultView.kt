package racingcar.view

object ResultView {

    fun printRacingProcess(racingCarNames: List<String>, racingHistory: Array<Array<Int>>) {
        println("실행 결과")

        val tryCount = racingHistory[0].size
        repeat(tryCount) { tryCnt ->
            printRacingStep(racingCarNames, racingHistory, tryCnt)
        }
    }

    private fun printRacingStep(
        racingCarNames: List<String>,
        racingHistory: Array<Array<Int>>,
        tryCnt: Int
    ) {
        repeat(racingCarNames.size) { racingCnt ->
            print("${racingCarNames[racingCnt]} : ")
            print("-".repeat(racingHistory[racingCnt][tryCnt]))
            println()
        }
        println()
    }
}
