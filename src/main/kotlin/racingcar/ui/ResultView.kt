package racingcar.ui

internal class ResultView {
    fun printInitResult() {
        println("실행 결과")
    }

    fun printCarMove(moveResult: String) {
        println(moveResult)
    }

    fun printLineSpacing() {
        println()
    }

    //
    // fun printResult(racingCarInfo: RacingCarInfo, printIndex: Int) {
    //     if (printIndex == 0) {
    //         println("실행 결과")
    //     }
    //
    //     for (resultMoveCount in racingCarInfo.resultMoveList) {
    //         println(RacingCarMove.getMoveString(resultMoveCount))
    //     }
    //
    //     if (printIndex < racingCarInfo.tryCount - 1) {
    //         println()
    //     }
    // }
}
