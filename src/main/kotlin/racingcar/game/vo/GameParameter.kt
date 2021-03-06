package racingcar.game.vo

import java.lang.IllegalArgumentException

const val MAX_CAR_NAME = 5

data class GameParameter(val nameOfCar: List<String>, val numOfGame: Int) {
    init {
        nameOfCar.forEach {
            if (it.isBlank()) throw IllegalArgumentException("자동차 이름은 blank 값이 될 수 없습니다.")
            if (it.length > MAX_CAR_NAME) throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }
}
