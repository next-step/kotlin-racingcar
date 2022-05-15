package racingCar
class Car(private val tryCount: Int, private val Random: IRandom) {
    var position: Int = 0

    fun move() {
        for (i: Int in 1..tryCount) {
            position = if (Random.generate() >= 4) position + 1 else position
        }
    }
}