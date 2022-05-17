package racing.view

import racing.exception.CarNameLengthExcessException

class InputView {

    fun readInRoundSize(): Int {
        println("시도할 횟수는 몇 회인가요?")

        var roundSize = 0
        kotlin.runCatching {
            readln().toInt()
        }.fold(
            onSuccess = { roundSize = it },
            onFailure = { exception -> throw exception }
        )

        return roundSize
    }

    fun readInCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)")

        var carNames: List<String> = emptyList()
        kotlin.runCatching {
            val carNames = readln().split(",")
            validateCarNames(carNames)
            carNames
        }.fold(
            onSuccess = { carNames = it },
            onFailure = { exception -> throw exception }
        )

        return carNames
    }

    private fun validateCarNames(carNames: List<String>) {
        if (!carNames.none { it.length > 5 }) {
            throw CarNameLengthExcessException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}
