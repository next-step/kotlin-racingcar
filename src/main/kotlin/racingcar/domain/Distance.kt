package racingcar.domain

class Distance(private var distance: Int = DEFAULT_DISTANCE) {

    fun getDistance() = distance

    fun move() = distance++

    companion object {
        private const val DEFAULT_DISTANCE = 0
    }
}
