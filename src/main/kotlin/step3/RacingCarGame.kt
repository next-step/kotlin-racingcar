package step3

class RacingCarGame {

    fun progressGame(totalRound: Long, cars: List<Car>): List<RacingCarRoundResult> {
        return (START_ROUND..totalRound)
            .map { round ->
                val racingCarDriveResults = cars.map { car ->
                    car.drive()
                    RacingCarDriveResult(car.carNumber, car.position)
                }
                    .toList()
                RacingCarRoundResult(round, racingCarDriveResults)
            }
    }

    companion object {
        const val MIN_RANDOM_DRIVE_NUMBER: Long = 4
        const val RANDOM_NUMBER_BASE: Long = 0
        const val RANDOM_NUMBER_LIMIT: Long = 9
        const val START_ROUND = 1
    }
}

fun main() {
    val racingCarGame = RacingCarGame()
    val inputView = RacingCarGameInputView()
    val resultView = RacingCarGameResultView()

    val totalCarCount = inputView.totalCarCount
    val totalRound = inputView.totalRound

    val randomNumberGenerator = RandomNumberGenerator(
        randomBase = RacingCarGame.RANDOM_NUMBER_BASE,
        randomLimit = RacingCarGame.RANDOM_NUMBER_LIMIT
    )

    val cars = RacingGameCarFactory.createRandomDriveCars(
        totalCarCount = totalCarCount,
        randomNumberGenerator = randomNumberGenerator,
        RacingCarGame.MIN_RANDOM_DRIVE_NUMBER
    )

    val roundResults = racingCarGame.progressGame(totalRound = totalRound, cars = cars)

    resultView.print(racingCarRoundResult = roundResults, totalRound = totalRound)
}
