package racingcar.game.vo

import java.lang.IllegalArgumentException

class GameParameter(val nameOfCar: List<String>, val numOfGame: Int) {
    init {
        nameOfCar.forEach {
            if (it.isBlank()) throw IllegalArgumentException("자동차 이름은 blank 값이 될 수 없습니다.")
        }
    }
}
