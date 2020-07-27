import kotlin.random.Random

const val RANDOM_RANGE = 10
class CarController {

    private fun makeCars(count: Int): List<Car> {
        var cars = mutableListOf<Car>()
        for (i in 0 until count) {
            cars.add(Car())
        }

        return cars
    }

    fun play(inputView: InputView, resultView: ResultView) {
        val cars = makeCars(inputView.carCountInput())
        val playCount = inputView.playCountInput()

        resultView.printInit()
        repeat(playCount) {
            resultView.printResult(cars.map { it.accelerate(Random.nextInt(RANDOM_RANGE)) })
        }
    }
}

fun main() {
    val carController = CarController()
    carController.play(InputView(), ResultView())
}
