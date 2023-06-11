package study.racinggame.domain

class RacingGameConfiguration private constructor(
    val nameOfCars: List<String>,
    val numberOfStages: Int,
) {

    fun build(): RacingGame {
        val cars = nameOfCars.map { Car(it, RandomSeedEngine()) }
        return RacingGame(cars, numberOfStages)
    }

    companion object {
        fun of(nameOfCars: List<String>, numberOfStages: Int): RacingGameConfiguration {
            if (nameOfCars.size < 2) {
                throw IllegalArgumentException()
            }
            if (numberOfStages < 1) {
                throw IllegalArgumentException()
            }

            return RacingGameConfiguration(nameOfCars, numberOfStages)
        }
    }
}
