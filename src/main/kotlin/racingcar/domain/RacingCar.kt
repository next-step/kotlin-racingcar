package racingcar.domain

class RacingCar(
    var position: Int = 0
) {
    companion object {
        private const val MOVE_POSSIBLE_NUMBER = 4;
    }

    fun move(input: Int) {
        if (movePossible(input)) {
            position++;
        }
    }

    private fun movePossible(input: Int) = input >= MOVE_POSSIBLE_NUMBER
}
