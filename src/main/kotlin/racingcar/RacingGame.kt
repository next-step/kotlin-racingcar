package racingcar

class RacingGame(carCnt: Int, val tryCnt: Int) {
    var cars = mutableListOf<Car>()

    init {
        repeat(carCnt) { cars.add(Car()) }
    }

    fun execute() {
        val resultView = ResultView()
        repeat(tryCnt) {
            cars.forEach {
                it.move(it.generate())
                resultView.view(it.position)
                resultView.newLine()
            }
            resultView.newLine()
        }
    }
}
