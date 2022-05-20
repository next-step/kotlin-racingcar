package racingcar.domain

class Cars private constructor(carNames: String) {
    val carList : List<Car>

    init {
         carList = carNames
            .split(",")
            .map(Car::makeCar)
    }

    fun run(movingStrategy: MovingStrategy) {
        carList.forEach{ car: Car -> car.move(movingStrategy) }
    }

    fun getWinnerList():List<String> {
        val maxPosition = carList.maxOf { it.position }
        return carList.asSequence().filter { it.position == maxPosition }.map { car -> car.name }.toList()
    }

    companion object {
        fun from(carNames: String): Cars {
            return Cars(carNames)
        }
    }
}
