package carracing.game.domain

import carracing.game.domain.data.Car
import carracing.game.domain.data.Race
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class CarRacingModel {
    private var carsAmount: Int = 0
    private var roundsAmount: Int = 0

    private val raceFlow: Flow<Race> =
        flow {
            var race = Race(round = 0, cars = List(carsAmount) { Car(position = 1) })
            repeat(roundsAmount) {
                race = advanceRace(race)
                emit(race)
                delay(50)
            }
        }

    fun assignCarsAmount(input: String?): Boolean {
        if (input != null && isInputValid(input)) {
            carsAmount = input.toInt()
            return true
        }
        return false
    }

    fun assignRoundsAmount(input: String?): Boolean {
        if (input != null && isInputValid(input)) {
            roundsAmount = input.toInt()
            return true
        }
        return false
    }

    fun getRaceFlow(): Flow<Race> {
        if (carsAmount <= 0 || roundsAmount <= 0) {
            throw IllegalArgumentException("Cars and rounds amount should be bigger than 0")
        }
        return raceFlow
    }

    private fun advanceRace(race: Race): Race {
        race.cars.forEach {
            if (Random.nextBoolean()) {
                it.position++
            }
        }
        return race.copy(round = race.round + 1)
    }

    private fun isInputValid(input: String): Boolean {
        val inputInt = input.toIntOrNull()
        return inputInt != null && inputInt > 0
    }
}
