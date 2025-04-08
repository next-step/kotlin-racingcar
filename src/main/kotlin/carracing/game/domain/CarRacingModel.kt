package carracing.game.domain

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import kotlin.random.Random

class CarRacingModel(
    private val random: Random = Random,
) {
    private var cars: List<String>? = null
    private var roundsAmount: Int? = null

    fun assignCars(input: String?) {
        val carsNames = input?.split(',')
        require(carsNames != null && carsNames.size >= MIN_CARS_AMOUNT) {
            "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
        this.cars = carsNames
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
            return createRaceSequence(rounds = rounds, carsNames = cars)
        }
        throw IllegalStateException("Cars and rounds amount were not initialized")
    }

    private fun createRaceSequence(
        rounds: Int,
        carsNames: List<String>,
    ): Sequence<Race> =
        sequence {
            val race = initRace(carsNames)
            repeat(rounds) {
                race.advanceRace()
                yield(race)
            }
        }

    private fun initRace(carsNames: List<String>): Race =
        Race(
            cars =
                List(carsNames.size) {
                    Car.of(
                        name = carsNames[it],
                        generateMoveNumber =
                            { random.nextInt(GENERATED_NUMBER_UPPER_LIMIT) },
                    )
                },
        )
}

internal const val GENERATED_NUMBER_UPPER_LIMIT = 10
internal const val MIN_CARS_AMOUNT = 2
internal const val MIN_ROUNDS_AMOUNT = 1
