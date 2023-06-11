package racingcar

object RacingGameCarFactory {

    fun createRandomDriveCars(
        totalCarCount: Long,
        randomNumberGenerator: RandomNumberGenerator,
        minDriveRandomNumber: Long
    ) = (1..totalCarCount)
        .map {
            RandomDriveCar(
                carNumber = it,
                randomNumberGenerator = randomNumberGenerator,
                minDriveRandomNumber = minDriveRandomNumber,
                name = "UNKNOWN",
            )
        }

    fun createRandomDriveCars(
        carNames: List<String>,
        randomNumberGenerator: RandomNumberGenerator,
        minDriveRandomNumber: Long
    ) = carNames.mapIndexed { index, carName ->
        RandomDriveCar(
            carNumber = index.toLong() + 1,
            randomNumberGenerator = randomNumberGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            name = carName,
        )
    }
}
