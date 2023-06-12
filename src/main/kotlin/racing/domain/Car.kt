package racing.domain

class Car(
    private val name: String,
    private var distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    fun move(): RacingPhaseRecord {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }

        return RacingPhaseRecord(name, distance)
    }

    companion object {
        const val INITIAL_DISTANCE = 1
    }
}
