package racingCar

class Car() {
    var position: Int = 0

    fun moveFor(movingPoint: Int) {
        position = if (movingPoint >= 4) position + 1 else position
    }
}
