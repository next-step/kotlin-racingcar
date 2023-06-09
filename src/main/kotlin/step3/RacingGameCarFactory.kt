package step3

class RacingGameCarFactory {

    companion object {
        fun createRandomDriveCars(
            totalCarCount: Long,
            randomNumberGenerator: RandomNumberGenerator,
            minDriveRandomNumber: Long
        ) = (1..totalCarCount)
            .map {
                RandomDriveCar(
                    carNumber = it,
                    randomNumberGenerator = randomNumberGenerator,
                    minDriveRandomNumber = minDriveRandomNumber
                )
            }
            .toList()
    }
}
