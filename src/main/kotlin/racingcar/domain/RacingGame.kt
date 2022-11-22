package racingcar.domain

class RacingGame(private val cars: List<Car>, private val turn: Int) {

    private var nowTurn = 0

    val isPlaying
        get() = nowTurn < turn

    fun playTurn(): Result {
        if (isPlaying) {
            nowTurn++
            moveCars()
        }

        return Result(cars)
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move()
        }
    }

    fun getLastState(): List<Car> {
        return cars
    }
}

class Result(val cars: List<Car>)
