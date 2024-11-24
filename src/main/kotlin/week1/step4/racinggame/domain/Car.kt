package week1.step4.racinggame.domain

class Car(val carName: CarName, position: Int = DEFAULT_POSITION) {
    var position: Int = position
        private set

    fun move(randomNumber: RandomNumber) {
        if (canMove(randomNumber)) {
            position++
        }
    }

    fun isWin(other: Car): Boolean {
        return position > other.position
    }

    fun isDraw(other: Car): Boolean {
        return position == other.position
    }

    private fun canMove(randomNumber: RandomNumber): Boolean {
        return randomNumber.value in FORWARDING_NUMBERS
    }

    companion object {
        const val DEFAULT_POSITION = 0
        private val FORWARDING_NUMBERS = listOf(4, 5, 6, 7, 8, 9)
    }
}
