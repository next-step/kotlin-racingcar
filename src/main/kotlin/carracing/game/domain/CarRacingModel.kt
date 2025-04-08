package carracing.game.domain

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import kotlin.random.Random

class CarRacingModel(
    private val random: Random = Random,
) {
    private var cars: List<Car>? = null
    private var roundsAmount: Int? = null

    fun assignCars(input: String?) {
        val carsNames = input?.split(',')
        require(carsNames != null && carsNames.size >= MIN_CARS_AMOUNT) {
            "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
        cars = initCars(carsNames)
    }

    fun assignRoundsAmount(input: String?) {
        val inputInt = input?.toIntOrNull()
        require(inputInt != null && inputInt >= MIN_ROUNDS_AMOUNT) {
            "Rounds amount should be at least $MIN_ROUNDS_AMOUNT"
        }
        roundsAmount = inputInt
    }

    fun getRaceSequence(): Sequence<Race> {
        val cars = cars
        val rounds = roundsAmount
        if (cars != null && rounds != null) {
            return createRaceSequence(rounds = rounds, cars = cars)
        }
        throw IllegalStateException("Cars and rounds amount were not initialized")
    }

    private fun createRaceSequence(
        rounds: Int,
        cars: List<Car>,
    ): Sequence<Race> =
        sequence {
            val race = Race(cars)
            repeat(rounds) {
                race.advanceRace()
                yield(race)
            }
        }

    private fun initCars(carsNames: List<String>): List<Car> =
        List(carsNames.size) {
            Car.of(
                name = carsNames[it],
                generateMoveNumber =
                    { random.nextInt(GENERATED_NUMBER_UPPER_LIMIT) },
            )
        }
}

internal const val GENERATED_NUMBER_UPPER_LIMIT = 10
internal const val MIN_CARS_AMOUNT = 2
internal const val MIN_ROUNDS_AMOUNT = 1
