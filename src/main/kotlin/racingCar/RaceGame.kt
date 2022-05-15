package racingCar

class RaceGame(private val inputView: InputView, private val resultView: ResultView) {
    fun start() {
        val carCount = inputView.askCarCount()
        val tryCount = inputView.askTryCount()

        val cars = mutableListOf<Car>()
        val carPositions = mutableListOf<Int>()

        for (i:Int in 1..carCount) cars.add(Car(tryCount, Random()))

        cars.forEach {
            it.move()
            carPositions.add(it.position)
        }

        resultView.show(carPositions)
    }
}