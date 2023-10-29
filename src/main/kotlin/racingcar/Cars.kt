package racingcar

class Cars(carCount: Int) {

    var carList: List<Car>

    init {
        carList = initCar(carCount)
    }

    private fun initCar(carCount: Int): List<Car> {
        return (1..carCount).map { Car() }
    }

    fun operateCars(): Cars {
        carList = carList.map { car ->
            car.move(generate())
        }
        return this
    }
}
