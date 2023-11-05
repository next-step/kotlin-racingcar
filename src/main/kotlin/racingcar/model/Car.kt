package racingcar.model

class Car(
    private val engine: Engine,
    val carName: CarName
) {
    var position: Long = 0L
        private set

    fun move(): Long {
        if (engine.canMove()) position++
        return position
    }
}
