package racingcar.domain

class Car {
    private var location = 1

    fun isMoveOrStop() {
        val randomNum = generateRandomNum()
        if (randomNum >= 4) {
            location++
        }
    }

    private fun generateRandomNum(): Int {
        return (0..9).random()
    }

    fun getLocation(): Int {
        return location
    }
}
