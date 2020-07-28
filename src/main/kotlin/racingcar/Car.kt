package racingcar

class Car(val name: String) {
    companion object {
        const val MOVABLE_VALUE = 4
    }

    private var currentPosition = 0
    fun moveForward(): Int {
        if (canMove()) moveOneBlock()
        return currentPosition
    }

    private fun moveOneBlock() {
        currentPosition++
    }

    private fun canMove(): Boolean {
        val randomValue = (0..9).random()
        return canMove(randomValue)
    }

    private fun canMove(randomValue: Int) = randomValue >= MOVABLE_VALUE
}
