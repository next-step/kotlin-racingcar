package racingcar.domain

data class Location(
    val value: Int
) : Comparable<Location> {
    init {
        require(value >= MIN_LOCATION) {
            "자동차의 위치는 0 미만일 수 없습니다. (입력: $value)"
        }
    }

    fun forward(): Location {
        return Location(value + MOVING_DISTANCE)
    }

    companion object {
        private const val MIN_LOCATION = 0
        private const val MOVING_DISTANCE = 1

        val BASE_LOCATION = Location(0)
    }

    override fun compareTo(other: Location): Int {
        return value - other.value
    }
}
