package racingCar

const val STANDARD_VALUE_TO_MOVE = 4

class Car {

    var distance: Int = 0

    fun changeStateRacingCar(inputRandomNum: Int) {
        if (inputRandomNum >= STANDARD_VALUE_TO_MOVE) {
            return move(true)
        }
    }

    fun move(isMove: Boolean) {
        if (isMove) distance += 1
    }
}
