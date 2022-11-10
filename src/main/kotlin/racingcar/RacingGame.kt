package racingcar

fun main() {
    RacingGame().start()
}

class RacingGame(
    private val inputView: InputView = InputView(),
    private val resultView: ResultView = ResultView(),
    private val movable: Movable = Movable()
) {

    fun start(setting: Setting = inputView.receiveSetting()): List<Car> {
        val cars = generateCars(setting.numberOfCars)

        repeat(setting.numberOfLab) {
            playTurn(cars)
        }

        return cars
    }

    private fun playTurn(cars: List<Car>) {
        cars.forEach { car ->
            if (movable.canGo()) car.go()
        }
        resultView.displayResult(cars)
    }

    private fun generateCars(numberOfCars: Int): List<Car> {
        return List(numberOfCars) { it -> Car(name = it.toString()) }
    }
}
