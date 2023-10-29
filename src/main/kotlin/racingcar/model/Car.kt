package racingcar.model

class Car(
    private val engine: Engine
) {
    private var position: Long = 0L

    fun move(): Long {
        if (engine.canMove()) position++
        return position
    }

    fun generateResult(): CharSequence {
        return StringBuilder().apply {
            repeat(position.toInt()) {
                append(ROAD)
            }
        }
    }

    fun getPosition(): Long {
        return position
    }

    companion object {
        const val ROAD = "-"
    }
}
