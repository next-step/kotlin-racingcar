package domain

class RacingCarEngine : Engine {
    override fun getRandomNumber(): Int {
        return (0..9).random()
    }

    override fun isMoving(number: Int): Boolean = number >= FORWARD_CONDITION_NUMBER

    companion object {
        const val FORWARD_CONDITION_NUMBER = 4
    }
}
