package racing

class Car(
    private var distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    fun move(): RacingPhaseRecord {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }

        return RacingPhaseRecord(distance)
    }

    companion object {
        const val INITIAL_DISTANCE = 1
    }
}
