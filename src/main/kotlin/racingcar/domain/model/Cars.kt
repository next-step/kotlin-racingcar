package racingcar.domain.model

class Cars(private val carList: List<Car> = emptyList()) {

    init {
        require(carList.isNotEmpty()) { "자동차 경주자가 있어야 합니다." }
    }

    fun findMostFarthestCar(): Cars {
        val farthestPosition: Int = findMostFarthestPosition()
        val winnerList: List<Car> = findPositionMatchedCars(farthestPosition)
        return Cars(winnerList)
    }

    fun names(): List<String> {
        return carList.map { car -> car.carName.name }
    }

    fun race() {
        carList.forEach { car ->
            car.moveTo(count = (0..9).random())
        }
    }

    fun copy(): Cars {
        val cars = carList.map { car -> car.copy() }
        return Cars(cars)
    }

    fun forEach(eachAction: (Car) -> Unit) {
        carList.forEach(eachAction)
    }

    private fun findPositionMatchedCars(position: Int) = carList.filter { car -> car.position == position }

    private fun findMostFarthestPosition() = carList.maxOf { car -> car.position }
}
