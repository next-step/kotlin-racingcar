package racing.view

import racing.domain.CarName

object InputView {

    const val INPUT_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."
    const val INPUT_ATTEMPT_MESSAGE = "시도할 횟수는 몇 회인가요?"
    const val INPUT_ATTEMPT_EXCEPTION_MESSAGE = "시도할 횟수는 숫자 형식으로 입력해 주세요"

    fun getCarNames(): List<CarName> {
        println(INPUT_CAR_MESSAGE)
        return readln().split(",").map { CarName(it) }
    }

    fun getTryCount(): Int {
        println(INPUT_ATTEMPT_MESSAGE)
        return readLine()?.toIntOrNull()
            ?: throw IllegalArgumentException(INPUT_ATTEMPT_EXCEPTION_MESSAGE)
    }
}
