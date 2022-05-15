package game.racingcar.view

import game.racingcar.util.requireOrThrow

class StandardInputView : InputView {
    override var carNames: List<String> = arrayListOf()
    override var numberOfLap: Int = 0

    override fun init() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        carNames = readln().split(",")
            .requireOrThrow("자동차 이름은 빈 값일 수 없습니다.") { it.isNotBlank() }
            .map { it.take(5) }
        println("시도할 횟수는 몇 회인가요?")
        numberOfLap = readln().toInt()
    }

    override fun numberOfCar(): Int {
        return carNames.size
    }
}
