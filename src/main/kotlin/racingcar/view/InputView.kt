package racingcar.view

import racingcar.view.CarViewConstant.COMMA

object InputView {
    fun inputCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readlnOrNull()?.takeIf { it.isNotBlank() }
            ?.split(COMMA)
            ?: throw IllegalArgumentException("The name cannot be null or blank")
    }

    fun inputMoveTryCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return readlnOrNull()?.toInt()
            ?: throw IllegalArgumentException("The try count cannot be null")
    }
}
