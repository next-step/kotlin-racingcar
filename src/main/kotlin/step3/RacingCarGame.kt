package step3

class RacingCarGame {

    companion object {
        const val MIN_RANDOM_DRIVE_NUMBER: Long = 4
        const val RANDOM_NUMBER_BASE: Long = 0
        const val RANDOM_NUMBER_LIMIT: Long = 9
        const val START_ROUND = 1
    }

    fun execute() {
        val inputView = RacingCarGameInputView()
        val totalCarCount = inputView.totalCarCount
        val totalRound = inputView.totalRound

        val racingCarDriveResults = progressGame(totalCarCount = totalCarCount, totalRound = totalRound)

        val resultView = RacingCarGameResultView()
        resultView.print(racingCarDriveResults = racingCarDriveResults, totalRound = totalRound)
    }

    private fun progressGame(totalCarCount: Long, totalRound: Long): List<RacingCarDriveResult> {
        val randomNumberGenerator = RandomNumberGenerator(RANDOM_NUMBER_BASE, RANDOM_NUMBER_LIMIT)
        val cars = generateCars(totalCarCount, randomNumberGenerator)

        return (START_ROUND..totalRound)
            .map { round ->
                cars.map { car ->
                    car.drive()
                    RacingCarDriveResult(round, car.carNumber, car.position)
                }
            }
            .flatten()
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

    racingCarGame.execute()
}
