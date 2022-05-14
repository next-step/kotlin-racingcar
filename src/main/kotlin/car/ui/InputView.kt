package car.ui

import car.ui.dto.RacingCarInput

object InputView {
    fun input(): RacingCarInput {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        val carNames = readln().split(",")

        println("시도할 횟수는 몇 회인가요 ?")
        val tryCount =
            readln().toIntOrNull() ?: throw IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다.")

        return RacingCarInput(carNames, tryCount)
    }
}
