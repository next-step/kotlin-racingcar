package racingcar.domain

object RacingGameCarFactory {

    fun createRandomDriveCars(
        carNames: List<String>,
        randomNumberGenerator: RandomNumberGenerator,
        minDriveRandomNumber: Long,
    ) = carNames.mapIndexed { index, carName ->
        createRandomDriveCar(
            carNumber = index.toLong() + 1,
            randomNumberGenerator = randomNumberGenerator,
            minDriveRandomNumber = minDriveRandomNumber,
            carName = carName,
        )
    }

    private fun createRandomDriveCar(
        carNumber: Long,
        randomNumberGenerator: RandomNumberGenerator,
        minDriveRandomNumber: Long,
        carName: String = "UNKNOWN",
    ) = RandomDriveCar(
        carNumber = carNumber,
        randomNumberGenerator = randomNumberGenerator,
        minDriveRandomNumber = minDriveRandomNumber,
        name = carName
    )
}
