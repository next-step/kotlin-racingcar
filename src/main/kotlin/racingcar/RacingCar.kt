package racingcar

import racingcar.data.RacingCarInfo
import racingcar.ui.InputView
import racingcar.ui.ResultView
import java.security.SecureRandom

object RacingCar {
    fun startRace() {
        val inputView = InputView()
        val carCount = inputView.inputCarCount()
        val tryCount = inputView.inputTryCount()
        val carVo = RacingCarInfo(carCount, tryCount, ArrayList(Array(carCount) { 0 }.toList()))

        val resultView = ResultView()
        resultView.printInitResult()

        for (i in 0 until carVo.tryCount) {
            moveCars(carVo.resultMoveList)

            for (resultMoveCount in carVo.resultMoveList) {
                resultView.printCarMove(getMoveString(resultMoveCount))
            }

            if (i < carVo.tryCount - 1) {
                resultView.printLineSpacing()
            }
        }
    }

    fun moveCars(moveCountList: ArrayList<Int>) {
        moveCountList.forEachIndexed { index, _ ->
            if (checkMoveValue(createRandomInt())) {
                moveCountList[index] ++
            }
        }
    }

    fun createRandomInt(): Int = SecureRandom.getInstanceStrong().nextInt(10)

    fun checkMoveValue(value: Int): Boolean = value >= 4

    fun getMoveString(moveCount: Int): String {
        return StringBuilder().apply {
            for (i in 0 until moveCount) {
                append("-")
            }
        }.toString()
    }
}
