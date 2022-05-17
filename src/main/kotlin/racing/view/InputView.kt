package racing.view

import racing.exception.CarNameLengthExcessException

class InputView {

    fun readInRoundSize(): Int {
        println("시도할 횟수는 몇 회인가요?")

        return readln().toInt()
    }

    fun readInCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")

        val carNames = readln().split(",")
        validateCarNames(carNames)
        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (!carNames.none { it.length > 5 }) {
            throw CarNameLengthExcessException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}
