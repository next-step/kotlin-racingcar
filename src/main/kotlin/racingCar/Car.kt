package racingCar

class Car() {
    var position: Int = 0

    fun move(condition: Int) {
        position = if (condition >= 4) position + 1 else position
    }
}
