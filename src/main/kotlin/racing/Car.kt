package racing

class Car(
    var distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    companion object {
        const val INITIAL_DISTANCE = 1
    }

    fun move() {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }
    }
}
