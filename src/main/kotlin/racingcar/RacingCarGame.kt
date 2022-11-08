package racingcar

class RacingCarGame(numberOfCar: Int, private val numberOfTrial: Int) {
    private val cars: List<Car> = (0..numberOfCar).map { i -> Car(i) }.toList()

    fun startGame(): RacingCarGameSnapShots {
        for (i in 0 until numberOfTrial) {
            move()
        }
        return RacingCarGameSnapShots(cars)
    }

    private fun move() {
        for (i in cars.indices) {
            val nextMovement = decideMovement()
            cars[i].move(nextMovement)
        }
    }

    private fun decideMovement(): Int {
        val random: Int = ((Math.random() * 10)).toInt()
        if (random < 4) {
            return 0
        } else {
            return random
        }
    }
}
