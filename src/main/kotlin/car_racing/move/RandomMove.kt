package car_racing.move

class RandomMove : Move {
    override fun isMove(): Boolean {
        return (RANDOM_RANGE_FROM..RANDOM_RANGE_TO).random() >= RANDOM_MOVE_CRITERIA
    }

    companion object {
        private const val RANDOM_RANGE_FROM = 0
        private const val RANDOM_RANGE_TO = 9
        private const val RANDOM_MOVE_CRITERIA = 4
    }
}
