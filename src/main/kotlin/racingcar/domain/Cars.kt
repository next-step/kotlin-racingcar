package racingcar.domain

import racingcar.dto.WinnerDto

class Cars(nameOfCars: List<String>, movingConditionStrategy: MovingConditionStrategy) {
    private val cars = mutableListOf<Car>()
    private val movingConditionStrategy: MovingConditionStrategy

    init {
        nameOfCars.map { cars.add(Car(it)) }
        this.movingConditionStrategy = movingConditionStrategy
    }

    fun race(numberOfGames: Int, callback: (WinnerDto) -> Unit) {
        iterateNumberOfGames(numberOfGames, callback)
    }

    fun getRacingCars(): List<Car> {
        return cars
    }

    private fun iterateNumberOfGames(numberOfGames: Int, callback: (WinnerDto) -> Unit) {
        for (numberOfGame in 0 until numberOfGames) {
            cars.forEach {
                it.move(movingConditionStrategy)
                callback(WinnerDto(it.getCarName(), it.getCarPosition()))
            }
        }
    }
}
