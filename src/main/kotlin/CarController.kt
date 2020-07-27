import kotlin.random.Random

class CarController {

    private fun makeCars(count: Int): List<Car> {
        var cars = mutableListOf<Car>()
        for (i in 0 until count) {
            cars.add(Car())
        }

        return cars
    }

    fun move(cars: List<Car>): List<Car> {
        cars.forEach {
            it.accelerate(Random.nextInt(10))
        }
        return cars
    }

    fun play(inputView: InputView, resultView: ResultView) {
        val cars = makeCars(inputView.carCountInput())
        val playCount = inputView.playCountInput()

        resultView.printInit()
        repeat(playCount) {
            move(cars)
            resultView.printResult(cars)
        }
    }
}

fun main() {
    val carController = CarController()
    carController.play(InputView(), ResultView())
}
