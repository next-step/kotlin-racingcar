package racingcar.domain

private const val ADD_MOVE_DISTANCE = 1

data class MoveDistance(private var _distance: Int = 0) {
    var distance = _distance
        private set

    fun move() {
        distance = distance.plus(ADD_MOVE_DISTANCE)
    }

    fun isSameCarPosition(maxPosition: Int): Boolean {
        return maxPosition == distance
    }
}
