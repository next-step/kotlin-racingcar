package step3

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
            )
        }
}
