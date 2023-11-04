package racinggame.domain

class RacingGame(
    private val cars: List<Car>,
    private val tryCount: Int,
    private val dice: Dice
) {

    fun play(): RacingGameResult {
        val result = (1..tryCount).map {
            roundPlay(cars)
        }.map { round ->
            RoundResult(round)
        }
        return RacingGameResult(getWinners(), result)
    }

    private fun roundPlay(cars: List<Car>) = cars.map { car ->
        val num = dice.pitch()
        car.move(num)
        Car(car.name, car.position)
    }

    private fun getWinners() = cars.sortedByDescending { car ->
        car.position
    }.let { sortedCars ->
        getJointWinner(sortedCars)
    }

    private fun getJointWinner(winners: List<Car>) = winners.filter { car ->
        car.position == winners.first().position
    }
}

