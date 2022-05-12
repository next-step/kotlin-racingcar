package racing.domain

import racing.ui.RacingUI
import racing.ui.UserInput

class CarRacing(
    private val carMaxPower: Int = DEFAULT_MAX_POWER,
    private val powerStrategy: PowerStrategy = RandomPowerStrategy(carMaxPower)
) {
    fun run(userInput: UserInput) {
        val cars = createCars(userInput.carNames)

        play(cars, userInput.moveCount)
    }

    private fun play(cars: List<Car>, moveCount: Int) {
        RacingUI.drawCars(cars)

        repeat(moveCount) {
            nextTurn(cars)
            RacingUI.drawCars(cars)
        }

        RacingUI.drawWinners(findWinners(cars))
    }

    private fun createCars(carNames: List<String>): List<Car> {
        return carNames.map { name ->
            Car(name = name, powerStrategy = powerStrategy)
        }
    }

    private fun nextTurn(cars: List<Car>) {
        cars.forEach(Car::move)
    }

    private fun findWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { maxPosition == it.position }
    }

    companion object {
        private const val DEFAULT_MAX_POWER = 10
    }
}
