package racingcar.domain

class RacingCar(val carName: String, var carDistance: Int = 0) {
    fun move(number: Int) {
        if (number > 4) {
            carDistance += 1
        }
    }
}
