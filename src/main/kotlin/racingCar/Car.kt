package racingCar

class Car(private val Random: IRandom) {
    var position: Int = 0

    fun moveFor(tryCount: Int) {
        for (i: Int in 1..tryCount) {
            position = if (Random.generate() >= 4) position + 1 else position
        }
    }
}
