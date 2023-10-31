package racingcar.model

class Car(
    private val engine: Engine
) {
    private var position: Long = 0L

    fun move(): Long {
        if (engine.canMove()) position++
        return position
    }

    fun getPosition(): Long {
        return position
    }
}
