package racing.domain

class Car(
    val name: String,
    distance: Int = INITIAL_DISTANCE,
    private val forwardCondition: ForwardCondition
) {

    var distance: Int = distance
        private set

    init {
        require(name.length <= CAR_NAME_MAXIMUM_LENGTH) { CAR_NAME_ERROR_MESSAGE }
    }

    fun move(): RacingPhaseRecord {
        val forwardCondition = forwardCondition.getForwardCondition()
        if (forwardCondition) {
            ++distance
        }

        return RacingPhaseRecord(name, distance)
    }

    companion object {
        private const val INITIAL_DISTANCE = 1
        private const val CAR_NAME_MAXIMUM_LENGTH = 5
        private const val CAR_NAME_ERROR_MESSAGE = "자동차 이름은 5자를 초과할 수 없습니다."
    }
}
