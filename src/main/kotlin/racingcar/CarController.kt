package racingcar

import kotlin.random.Random

private const val RANDOM_RANGE = 10

class CarController(private val carNames: List<String>, private val playCount: Int) {

    private fun makeCars(names: List<String>): List<Car> {
        val cars = mutableListOf<Car>()
        for (name in names) {
            cars.add(Car(name))
        }
        return cars
    }

    fun play(cars: List<Car>, accelerateNumbers: List<Int>) {
        cars.forEachIndexed { index, car -> car.accelerate(accelerateNumbers[index]) }
    }

    private fun getRandoms(size: Int): List<Int> {
        val randoms = mutableListOf<Int>()
        repeat(size) {
            randoms.add(Random.nextInt(RANDOM_RANGE))
        }
        return randoms
    }

    fun getWinner(cars: List<Car>): List<Car> {
        val maxValue = cars.maxBy { it.position }?.position ?: 0
        return cars.filter { car -> car.equalsCurrentPosition(maxValue) }
    }

    fun startGame(): List<Car> {
        val cars = makeCars(carNames)
        repeat(playCount) {
            play(cars, getRandoms(cars.size))
        }
        return cars
    }

    fun endGame(cars: List<Car>, resultView: ResultView) {
        resultView.printInit()
        for (i in 0 until playCount) {
            resultView.printResult(cars, i)
        }
        resultView.printWinner(getWinner(cars))
    }
}

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carController =
        CarController(inputView.carNamesInput(), inputView.playCountInput())
    carController.endGame(carController.startGame(), resultView)
}
