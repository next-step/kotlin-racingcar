package racingcar.ui

import racingcar.RacingCarMove
import racingcar.data.RacingCarInfo

internal class ResultView {
    fun printResult(racingCarInfo: RacingCarInfo, printIndex: Int) {
        if (printIndex == 0) {
            println("실행 결과")
        }

        for (resultMoveCount in racingCarInfo.resultMoveList) {
            println(RacingCarMove.getMoveString(resultMoveCount))
        }

        if (printIndex < racingCarInfo.tryCount - 1) {
            println()
        }
    }
}
