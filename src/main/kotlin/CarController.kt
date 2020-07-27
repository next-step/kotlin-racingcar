import kotlin.random.Random

const val RANDOM_RANGE = 10
class CarController {

    fun makeCars(count: Int): List<Car> {
        var cars = mutableListOf<Car>()
        for (i in 0 until count) {
            cars.add(Car())
        }

        return cars
    }

    fun move(cars: List<Car>): List<Car> {
        cars.forEach {
            it.accelerate(Random.nextInt(RANDOM_RANGE))
        }
        return cars
    }

    fun play(cars: List<Car>, resultView: ResultView) {
        move(cars)
        resultView.printResult(cars)
    }

    fun process(inputView: InputView, resultView: ResultView) {
        var cars = makeCars(inputView.carCountInput())
        val playCount = inputView.playCountInput()

        resultView.printInit()
        repeat(playCount) {
            play(cars, resultView)
        }
    }
}

fun main() {
    val carController = CarController()
    carController.process(InputView(), ResultView())
}
