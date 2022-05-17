package game.racingcar.view

import game.racingcar.util.requireOrThrow

class StandardInputView : InputView {
    private val carNames: List<String> by lazy {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        readln().split(",")
            .requireOrThrow("자동차 이름은 빈 값일 수 없습니다.") { it.isNotBlank() }
            .map { it.take(NAME_MAX_LENGTH) }
    }

    private val numberOfLap: Int by lazy {
        println("시도할 횟수는 몇 회인가요?")
        readln().toInt()
    }

    override fun carNames(): List<String> = carNames

    override fun numberOfLap(): Int = numberOfLap

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}
