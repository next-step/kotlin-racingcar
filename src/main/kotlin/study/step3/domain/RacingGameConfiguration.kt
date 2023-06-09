package study.step3.domain

class RacingGameConfiguration private constructor(
    val numberOfCars: Int,
    val numberOfTries: Int,
) {

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
