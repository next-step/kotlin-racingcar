package carracing.game.domain

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import kotlin.random.Random

class CarRacingModel(
    private val random: Random = Random,
) {
    private var carsAmount: Int? = null
    private var roundsAmount: Int? = null

    fun assignCarsAmount(input: String?) {
        val inputInt = input?.toIntOrNull()
        require(inputInt != null && inputInt >= MIN_CARS_AMOUNT) {
            "Cars amount should be at least $MIN_CARS_AMOUNT"
        }
        carsAmount = inputInt
    }

    fun assignRoundsAmount(input: String?) {
        val inputInt = input?.toIntOrNull()
        require(inputInt != null && inputInt >= MIN_ROUNDS_AMOUNT) {
            "Rounds amount should be at least $MIN_ROUNDS_AMOUNT"
        }
        roundsAmount = inputInt
    }

    fun getRaceSequence(): Sequence<Race> {
        val cars = carsAmount
        val rounds = roundsAmount
        if (cars != null && rounds != null) {
            return createRaceSequence(rounds = rounds, cars = cars)
        }
        throw IllegalStateException("Cars and rounds amount were not initialized")
    }

    private fun createRaceSequence(
        rounds: Int,
        cars: Int,
    ): Sequence<Race> =
        sequence {
            val race = Race(cars = List(cars) { Car() })
            repeat(rounds) {
                advanceRace(race)
                yield(race)
            }
        }

    private fun advanceRace(race: Race) {
        race.cars.forEach {
            it.move(random.nextInt(until = GENERATED_NUMBER_UPPER_LIMIT))
        }
        race.round++
    }
}

internal const val GENERATED_NUMBER_UPPER_LIMIT = 10
internal const val MIN_CARS_AMOUNT = 2
internal const val MIN_ROUNDS_AMOUNT = 1
