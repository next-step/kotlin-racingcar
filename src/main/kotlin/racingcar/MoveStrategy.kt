package racingcar

class MoveStrategy {
    companion object {
        private const val MIN_NUMBER_TO_MOVE = 4
        fun canMove(randomNumber: Int): Boolean {
            return randomNumber >= MIN_NUMBER_TO_MOVE
        }
    }
}
