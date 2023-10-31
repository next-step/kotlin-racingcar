package racinggame

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
    private val dice: Dice
) {

    private fun roundPlay(cars: List<Car>) = cars.map { car ->
        val num = dice.pitch()
        car.move(num)
        Car(car.name, car.position)
    }

    fun play() = (1..tryCount).map {
        roundPlay(cars)
    }.map { round ->
        RoundResult(round)
    }.let {
        RacingGameResult(it)
    }

    fun getWinners() = cars.sortedByDescending { car ->
        car.position
    }.let { sortedCars ->
        getJointWinner(sortedCars)
    }.let {
        PlayWinners(it)
    }

    private fun getJointWinner(winners: List<Car>) = winners.filter { car ->
        car.position == winners.first().position
    }
}

