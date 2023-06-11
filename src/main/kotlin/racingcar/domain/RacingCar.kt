package racingcar.domain

class RacingCar(
    private var position: Int = 0
) {
    fun move(input: Int) {
        if (movePossible(input)) {
            position++
        }
    }

    fun position(): Int {
        return position
    }

    private fun movePossible(input: Int): Boolean = input >= MOVE_POSSIBLE_NUMBER

    companion object {
        private const val MOVE_POSSIBLE_NUMBER = 4
    }
}
