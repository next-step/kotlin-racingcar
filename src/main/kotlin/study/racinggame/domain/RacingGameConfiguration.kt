package study.racinggame.domain

class RacingGameConfiguration private constructor(
    val nameOfCars: List<String>,
    val numberOfStages: Int,
) {

    fun build(): RacingGame {
        val cars = nameOfCars.map(::Participant)
            .map { Car(it, RandomSeedEngine, Position()) }
        return RacingGame(cars, numberOfStages)
    }

    companion object {
        fun of(nameOfCars: List<String>, numberOfStages: Int): RacingGameConfiguration {
            if (nameOfCars.size < 2) {
                throw InsufficientCarsException(nameOfCars.size)
            }
            if (numberOfStages < 1) {
                throw InsufficientStagesException(numberOfStages)
            }
            return RacingGameConfiguration(nameOfCars, numberOfStages)
        }
    }
}
