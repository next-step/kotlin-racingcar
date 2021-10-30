package racingcar.domain

data class MoveDistance(var distance: Int = 0) {

    fun move() {
        distance = distance.plus(ADD_MOVE_DISTANCE)
    }

    companion object {
        private const val ADD_MOVE_DISTANCE = 1
    }
}
