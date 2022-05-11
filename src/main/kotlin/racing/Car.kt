package racing

class Car {
    var position = 0
        private set

    fun move(randomValue: Int) {
        if (canMove(randomValue))
            position++
    }

    private fun canMove(randomValue: Int): Boolean {
        return randomValue >= 4
    }
}
