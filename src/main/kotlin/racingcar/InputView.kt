package racingcar

import racingcar.controller.RacingCarGame

object InputView {
    fun receiveInput(): RacingCarGame {
        println("자동차 대수는 몇 대인가요?")
        val numberOfCar = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("자동차 대수는 숫자를 입력해주세요")
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrial = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수 숫자를 입력해주세요")

        return RacingCarGame(numberOfCar, numberOfTrial)
    }
}
