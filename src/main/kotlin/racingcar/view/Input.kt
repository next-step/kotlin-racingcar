package racingcar.view

import racingcar.model.CarCount
import racingcar.model.TryNumber

class Input {

    fun getCarCount(): CarCount {
        println("자동차 대수는 몇 대 인가요?")
        return CarCount(readln().toIntOrNull() ?: throw IllegalArgumentException("하나의 숫자를 입력해주세요."))
    }

    fun getTryNumber(): TryNumber {
        println("시도할 횟수는 몇 회 인가요?")
        return TryNumber(readln().toIntOrNull() ?: throw IllegalArgumentException("하나의 숫자를 입력해주세요."))
    }
}
