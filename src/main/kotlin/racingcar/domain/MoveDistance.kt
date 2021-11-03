package racingcar.domain

data class MoveDistance(private var _distance: Int = 0) {
    var distance = _distance
        private set

    fun move() {
        distance = distance.plus(ADD_MOVE_DISTANCE)
    }

    companion object {
        private const val ADD_MOVE_DISTANCE = 1
    }
}
