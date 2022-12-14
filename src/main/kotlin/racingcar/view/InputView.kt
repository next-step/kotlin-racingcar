package racingcar.view

import racingcar.domain.RacingCarGame

object InputView {
    fun receiveInput(): RacingCarGame {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val names = readLine()?.split(",") ?: throw IllegalArgumentException("경주할 자동차 이름을 입력해주세요")
        println("시도할 횟수는 몇 회인가요?")
        val numberOfTrial = readLine()?.toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수 숫자를 입력해주세요")

        return RacingCarGame(names, numberOfTrial)
    }
}
