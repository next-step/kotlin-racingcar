package racingcar

class Cars(carNames: List<String>) {

    var carList: List<Car>

    init {
        carList = initCar(carNames)
    }

    private fun initCar(carNames: List<String>): List<Car> {
        return carNames.map { carName ->
            Car(carName)
        }
    }

    fun operateCars(): Cars {
        carList = carList.map { car ->
            car.move()
        }
        return this
    }

    fun isWinner(): List<String> {
        val maxPosition = carList.maxOf { it.position }
        return carList.filter { it.position == maxPosition }.map { it.carName }
    }
}
