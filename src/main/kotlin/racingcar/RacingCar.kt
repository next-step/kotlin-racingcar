package racingcar

fun main() {
    RacingCar.gameStart()
}

const val MOVE_CONDITION_NUMBER = 4

object RacingCar {
    fun gameStart() = race(InputView.getRace())

    private fun race(race: Race) = with(race) {
        val cars = List(size = numberOfCars) { Car() }

        repeat(numberOfRounds) { _ ->
            repeat(numberOfCars) { car ->
                if (checkMoveAvailable(randomNumber())) cars[car].position++
            }

            ResultView.showRaceResult(cars)
        }
    }

    private fun randomNumber() = (0..9).random()

    fun checkMoveAvailable(condition: Int) = condition >= MOVE_CONDITION_NUMBER
}
