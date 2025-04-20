package carracing.game.domain.data

import kotlin.random.Random

object CarsFactory {
    fun from(carsNames: List<String>): List<Car> =
        List(carsNames.size) {
            Car(
                name = carsNames[it],
                generateMoveNumber =
                    { Random.nextInt(GENERATED_NUMBER_UPPER_LIMIT) },
            )
        }
}

internal const val GENERATED_NUMBER_UPPER_LIMIT = 10
