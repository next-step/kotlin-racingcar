package racingcar

class Car(val name: String) {
    companion object {
        const val MOVABLE_VALUE = 4
    }

    // private setter 이 클래스 밖에서 이 프로퍼티의 값을 바꿀 수 없다.
    var currentPosition = 0
        private set

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

    fun isWinner(max: Int) = currentPosition == max
}
