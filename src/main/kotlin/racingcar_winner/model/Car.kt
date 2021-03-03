package racingcar_winner.model

const val CRITERIA_NUMBER = 4

class Car(
    val name: String
) {
    var progress: Int = 0
        private set

    private fun moveToForward() {
        progress += 1
    }

    fun tryToMoveForward(randomNumber: Int) {
        if (checkPossibleToMove(randomNumber)) moveToForward()
    }

    private fun checkPossibleToMove(randomNumber: Int): Boolean {
        return randomNumber > CRITERIA_NUMBER
    }
}
