package racingCar

class Car() {
    var position: Int = 0

    fun moveFor(tryCount: Int, movingPoint: Int) {
        for (i: Int in 1..tryCount) {
            position = if (movingPoint >= 4) position + 1 else position
        }
    }
}
