import kotlin.random.Random

const val RANDOM_RANGE = 10
class CarController(carCount: Int, private val playCount: Int) {
    private var cars: List<Car>

    init {
        cars = makeCars(carCount)
    }

    private fun makeCars(count: Int): List<Car> {
        val cars = mutableListOf<Car>()
        for (i in 0 until count) {
            cars.add(Car())
        }
        return cars
    }

    fun play(resultView: ResultView) {
        resultView.printInit()
        repeat(playCount) {
            cars.forEach {
                it.accelerate(Random.nextInt(RANDOM_RANGE))
            }
            resultView.printResult(cars)
        }
    }
}

fun main() {
    val inputView = InputView()
    val resultView = ResultView()

    val carCount = inputView.carCountInput()
    val playCount = inputView.playCountInput()

    val carController = CarController(carCount, playCount)
    carController.play(resultView)
}
