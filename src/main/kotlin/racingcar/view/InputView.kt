package racingcar.view

import racingcar.filter.ValueFilter

class InputView {

    fun inputCarName(): Int {
        println(CAR_NAME)
        return ValueFilter.verify(readLine()!!)
    }

    fun inputNumberOfAttempts(): Int {
        println(NUMBER_OF_ATTEMPTS)
        return ValueFilter.verify(readLine()!!)
    }

    companion object {
        private const val CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,)를 기준으로 구분합니다.)"
        private const val NUMBER_OF_ATTEMPTS = "시도할 횟수는 몇 회 인가요?"
    }
}
