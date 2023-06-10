package racingcar.domain

class Car {
    private var location = 1
    private val BASE_NUMBER_TO_MOVE = 4

    fun isMoveOrStop() {
        val randomNum = generateRandomNum()
        if (conditionToMove(randomNum)) location++
    }

    private fun conditionToMove(randomNum: Int) = randomNum >= BASE_NUMBER_TO_MOVE

    private fun generateRandomNum(): Int {
        return (0..9).random()
    }

    fun getLocation(): Int {
        return location
    }
}
