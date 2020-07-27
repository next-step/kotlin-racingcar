package racingcar

class RacingCar {
    var distance: Int = 0

    fun run(randomNum: Int) {
        if (isRunnable(randomNum)) distance++
    }

    fun isRunnable(randomNum: Int) = randomNum in 4..9
}
