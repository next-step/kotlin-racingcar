package study.racinggame.domain

class RacingGameConfiguration private constructor(
    val numberOfCars: Int,
    val numberOfTries: Int,
) {

    fun build(): RacingGame {
        val cars = (0 until numberOfCars).map { Car(RandomSeedEngine()) }
        return RacingGame(cars, numberOfTries)
    }

    companion object {
        fun of(numberOfCars: Int, numberOfTries: Int): RacingGameConfiguration {
            if (numberOfCars < 2) {
                throw IllegalArgumentException()
            }
            if (numberOfTries < 1) {
                throw IllegalArgumentException()
            }

            return RacingGameConfiguration(numberOfCars, numberOfTries)
        }
    }
}
