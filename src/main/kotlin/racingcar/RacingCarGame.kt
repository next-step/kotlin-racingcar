package racingcar

class RacingCarGame {

    fun progressGame(totalRound: Long, cars: List<Car>): RacingCarGameResult {
        require(totalRound >= 1) { "시도 횟수는 1 이상이어야 합니다." }
        require(cars.isNotEmpty()) { "자동차 대수는 1 이상이어야 합니다." }

        val gameRoundResults = (START_ROUND..totalRound)
            .map { round ->
                val roundResult = progressRound(cars)
                RacingCarRoundResult(round, roundResult)
            }

        val winnerNames = findWinnerNames(gameRoundResults = gameRoundResults, lastRound = totalRound)

        return RacingCarGameResult(winnerNames, gameRoundResults)
    }

    private fun progressRound(cars: List<Car>): List<RacingCarDriveResult> {
        return cars.map { car ->
            car.drive()
            RacingCarDriveResult(car.carNumber, car.position, car.name)
        }
    }

    private fun findWinnerNames(gameRoundResults: List<RacingCarRoundResult>, lastRound: Long): List<String> {
        val lastRoundResults = getLastRoundResults(gameRoundResults, lastRound)

        val maxPositionCarResult = lastRoundResults.maxBy { it.position }

        return lastRoundResults.asSequence()
            .filter { it.position == maxPositionCarResult.position }
            .map { it.carName }
            .toList()
    }

    private fun getLastRoundResults(
        gameRoundResults: List<RacingCarRoundResult>,
        lastRound: Long
    ) = gameRoundResults.asSequence()
        .filter { it.round == lastRound }
        .map { it.carDriveResults }
        .flatten()
        .toList()

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

    val carNames = inputView.carNames
    val totalRound = inputView.totalRound

    val randomNumberGenerator = RandomNumberGenerator(
        randomBase = RacingCarGame.RANDOM_NUMBER_BASE,
        randomLimit = RacingCarGame.RANDOM_NUMBER_LIMIT,
    )

    val cars = RacingGameCarFactory.createRandomDriveCars(
        carNames = carNames,
        randomNumberGenerator = randomNumberGenerator,
        RacingCarGame.MIN_RANDOM_DRIVE_NUMBER,
    )

    val gameResult = racingCarGame.progressGame(totalRound = totalRound, cars = cars)

    resultView.print(gameResult = gameResult, totalRound = totalRound)
}
