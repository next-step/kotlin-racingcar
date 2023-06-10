package racing

class Car(
    private var distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    fun move() {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }
    }

    fun getDistance() = distance

    companion object {
        const val INITIAL_DISTANCE = 1
    }
}
