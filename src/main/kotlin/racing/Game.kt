package racing

class Game(
    private val numberOfCar: Int,
    private val tryCount: Int
) {
    private val carList = List(numberOfCar) { Car() }
    private val resultView = ResultView()

    fun start() {
        repeat(tryCount) {
            run()
        }
    }

    private fun run() {
        carList.forEach {
            it.move()
        }

        resultView.view(carList)
    }
}
