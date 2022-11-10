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
        val cars = generateCars(setting.nameOfCars)

        repeat(setting.numberOfLab) {
            playTurn(cars)
        }

        endGame(cars)

        return cars
    }

    private fun playTurn(cars: List<Car>) {
        cars.forEach { car ->
            if (movable.canGo()) car.go()
        }
        resultView.displayResult(cars)
    }

    private fun endGame(cars: List<Car>) {
        val winner = makeWinner(cars)
        resultView.displayWinner(winner)
    }

    private fun makeWinner(cars: List<Car>): List<Car> {
        val maximumProgress = cars.maxOf { car -> car.progress }
        return cars.filter { car -> car.progress == maximumProgress }
    }

    private fun generateCars(nameOfCars: List<String>): List<Car> {
        return List(nameOfCars.size) { Car(name = nameOfCars[it]) }
    }
}
