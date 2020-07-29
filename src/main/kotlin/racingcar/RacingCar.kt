package racingcar

class RacingCar(carNames: List<String>) {
    private val cars = mutableListOf<Car>()
    private val winnerCars = mutableListOf<Car>()

    init {
        carNames.forEach {
            cars.add(Car(it))
        }
    }

    fun race(tryCount: Int): List<Car> {
        for (i in 1..tryCount) {
            moveForwardAll()
            // 현재 차들의 상태를 프린트한다 (분리하기)
            ResultView.view(cars)
        }
        return getWinner(cars)
    }

    private fun getWinner(cars: List<Car>): List<Car> {
        val max = cars.maxBy { it.currentPosition }!!.currentPosition
        cars.forEach {
            if (it.isWinner(max)) winnerCars.add(it)
        }
        return winnerCars
    }

    private fun moveForwardAll() {
        cars.forEach {
            it.moveForward()
        }
    }
}
