package racingcar.model

private const val MIN_NUMBER_TO_MOVE = 4

class MoveStrategy {
    companion object {
        fun canMove(randomNumber: Int): Boolean {
            return randomNumber >= MIN_NUMBER_TO_MOVE
        }
    }
}
