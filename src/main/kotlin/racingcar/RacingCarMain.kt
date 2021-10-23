package racingcar

import racingcar.racing.Racing.racingStart
import racingcar.view.InputView.getReadLine

object RacingCarMain {
    @JvmStatic
    fun main(args: Array<String>) {
        val carCount = getReadLine("자동차 대수는 몇대인가요?")
        val tryCount = getReadLine("시도할 횟수는 몇대인가요?")

        racingStart(carCount, tryCount)
    }
}
