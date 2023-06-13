package racing.domain

class Car(
    private val name: String,
    private var distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    init {
        require(name.length <= 5) { CAR_NAME_ERROR_MESSAGE }
    }

    fun move(): RacingPhaseRecord {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }

        return RacingPhaseRecord(name, distance)
    }

    companion object {
        const val INITIAL_DISTANCE = 1
        private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
    }
}
