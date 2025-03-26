package carracing.game.domain

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CarRacingModel(
    private val random: Random = Random,
) {
    private var carsAmount: Int? = null
    private var roundsAmount: Int? = null

    fun assignCarsAmount(input: String?) {
        val inputInt = input?.toIntOrNull()
        if (inputInt == null || inputInt < MIN_CARS_AMOUNT) {
            throw IllegalArgumentException("Cars amount should be at least $MIN_CARS_AMOUNT")
        }
        carsAmount = inputInt
    }

    fun assignRoundsAmount(input: String?) {
        val inputInt = input?.toIntOrNull()
        if (inputInt == null || inputInt < MIN_ROUNDS_AMOUNT) {
            throw IllegalArgumentException("Rounds amount should be at least $MIN_ROUNDS_AMOUNT")
        }
        roundsAmount = inputInt
    }

    fun getRaceFlow(): Flow<Race> {
        val cars = carsAmount
        val rounds = roundsAmount
        if (cars != null && rounds != null) {
            return createRaceFlow(rounds = rounds, cars = cars)
        }
        throw IllegalStateException("Cars and rounds amount were not initialized")
    }

    private fun createRaceFlow(
        rounds: Int,
        cars: Int,
    ): Flow<Race> =
        flow {
            val race = Race(cars = List(cars) { Car() })
            repeat(rounds) {
                advanceRace(race)
                emit(race)
                delay(300)
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
