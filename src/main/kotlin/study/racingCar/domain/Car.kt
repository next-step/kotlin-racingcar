package study.racingCar.domain

class Car {
    var movedNum = 0
        private set

    fun moveOneStep() {
        val randomNum = RANDOM_NUM
        if (randomNum >= 4) movedNum += 1
    }
    // companion Object : 4 => Forward Number

    companion object {
        val RANDOM_NUM = (0..9).random()
    }
}
