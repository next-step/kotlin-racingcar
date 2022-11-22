package racingcar.domain

@JvmInline
value class Distance(private val distance: Int = DEFAULT_DISTANCE) {

    fun getDistance() = distance

    fun move(): Distance {
        return Distance(distance + ONE_STEP)
    }

    companion object {
        private const val ONE_STEP = 1
        private const val DEFAULT_DISTANCE = 0
    }
}
