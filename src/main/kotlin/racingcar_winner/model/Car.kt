package racingcar_winner.model

class Car(
    var name: String
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
        return randomNumber > 4
    }
}
