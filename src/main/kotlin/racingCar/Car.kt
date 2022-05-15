package racingCar

interface ICar {
    var position: Int
    fun moveFor(tryCount: Int)
}
class Car(private val Random: IRandom): ICar {
    override var position: Int = 0

    override fun moveFor(tryCount: Int) {
        for (i: Int in 1..tryCount) {
            position = if (Random.generate() >= 4) position + 1 else position
        }
    }
}