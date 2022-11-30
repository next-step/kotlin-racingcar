package racingcar.domain

class Cars(nameOfCars: List<String>, movingConditionStrategy: MovingConditionStrategy) {
    private val cars = mutableListOf<Car>()
    private var movingConditionStrategy: MovingConditionStrategy

    init {
        nameOfCars.map { cars.add(Car(it)) }
        this.movingConditionStrategy = movingConditionStrategy
    }

    fun race(gameInputValue: GameInputValue, callback: (Int) -> Unit) {
        iterateNumberOfGames(gameInputValue, callback)
    }

    fun getRacingCars(): List<Car> {
        return cars
    }

    private fun iterateNumberOfGames(gameInputValue: GameInputValue, callback: (Int) -> Unit) {
        for (numberOfGames in 0 until gameInputValue.inputNumberOfGames) {
            iterateNumberOfCars(gameInputValue, callback)
        }
    }

    private fun iterateNumberOfCars(gameInputValue: GameInputValue, callback: (Int) -> Unit) {
        for (numberOfCars in 0 until gameInputValue.inputNameOfCars.size) {
            moveCar(numberOfCars)
            callback(numberOfCars)
        }
    }

    private fun moveCar(numberOfCars: Int) {
        cars[numberOfCars].move(movingConditionStrategy)
    }
}
