package racingcar.ui

import racingcar.data.RacingCarInfo

internal class InputView {
    fun execute(): RacingCarInfo {
        println("자동차 대수는 몇 대인가요?")
        val carCount = readLine()?.toInt() ?: 0

        println("시도할 횟수는 몇 회인가요?")
        val tryCount = readLine()?.toInt() ?: 0

        return RacingCarInfo(carCount, tryCount, ArrayList(Array(carCount) { 0 }.toList()))
    }
}
