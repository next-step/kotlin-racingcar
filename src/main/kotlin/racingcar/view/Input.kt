package racingcar.view

import racingcar.model.CarName
import racingcar.model.TryNumber

class Input {

    fun getCarNames(): List<CarName> {
        println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분).")

        return readln()
            .split(DEFAULT_SPLIT)
            .filter { it.isNotBlank() }
            .map { CarName(it.trim()) }
            .toList()
    }

    fun getTryNumber(): TryNumber {
        println("시도할 횟수는 몇 회 인가요?")
        return TryNumber(readln().toIntOrNull() ?: throw IllegalArgumentException("하나의 숫자를 입력해주세요."))
    }

    companion object {
        private const val DEFAULT_SPLIT = ","
    }
}
