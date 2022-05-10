package racingcar.property

data class Property(
    val FORWARD_THRESHOLD: Int = 4,
    val MIN_FORWARD_DISTANCE: Int = 0,
    val MAX_FORWARD_DISTANCE: Int = 9,
    val FORWARD_DISTANCE_RANGE: IntRange = 0..9

)
