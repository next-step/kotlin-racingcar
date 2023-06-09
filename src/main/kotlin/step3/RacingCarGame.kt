package step3

class RacingCarGame {

    companion object {
        const val MIN_RANDOM_DRIVE_NUMBER: Long = 4
        const val RANDOM_NUMBER_BASE: Long = 0
        const val RANDOM_NUMBER_LIMIT: Long = 9
        const val START_ROUND = 1
    }

    fun progressGame(totalCarCount: Long, totalRound: Long): List<RacingCarRoundResult> {
        val randomNumberGenerator = RandomNumberGenerator(RANDOM_NUMBER_BASE, RANDOM_NUMBER_LIMIT)
        val cars = generateCars(totalCarCount, randomNumberGenerator)

        return (START_ROUND..totalRound)
            .map { round ->
                val racingCarDriveResults = cars.map { car ->
                    car.drive()
                    RacingCarDriveResult(car.carNumber, car.position)
                }
                    .toList()
                RacingCarRoundResult(round, racingCarDriveResults)
            }
            .toList()
    }

    private fun generateCars(
        totalCarCount: Long,
        randomNumberGenerator: RandomNumberGenerator
    ) = (1..totalCarCount)
        .map {
            RandomDriveCar(
                carNumber = it,
                randomNumberGenerator = randomNumberGenerator,
                minDriveRandomNumber = MIN_RANDOM_DRIVE_NUMBER
            )
        }
        .toList()
}

fun main() {
    val racingCarGame = RacingCarGame()
    val inputView = RacingCarGameInputView()
    val resultView = RacingCarGameResultView()

    val totalCarCount = inputView.totalCarCount
    val totalRound = inputView.totalRound

    val roundResults = racingCarGame.progressGame(totalCarCount = totalCarCount, totalRound = totalRound)

    resultView.print(racingCarRoundResult = roundResults, totalRound = totalRound)
}
