package carracing

class Car(
    private var position: Int = 0,
    private val minConditionToMove: Int,
) {
    fun move(power: Int) {
        if (power >= minConditionToMove) {
            position++
        }
    }

    fun getPosition(): Int {
        return position
    }
}
