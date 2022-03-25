package racingcar.domain

enum class CarAction(val distance: Int) {

    MOVE(distance = 1), STOP(distance = 0);
}