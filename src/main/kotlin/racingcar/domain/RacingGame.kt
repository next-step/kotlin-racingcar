package racingcar.domain

class RacingGame(private val cars: List<Car>, private val turn: Int) {

    private var nowTurn = 0

    val isPlaying
        get() = nowTurn < turn

    fun playTurn(): CarStates {
        if (isPlaying) {
            nowTurn++
            moveCars()
        }

        return getStates()
    }

    private fun moveCars() {
        cars.forEach { car ->
            car.move()
        }
    }

    fun getStates(): CarStates {
        return CarStates(cars.map { car -> car.toState() })
    }
}

class CarStates(val cars: List<CarState>)
