package racingcar.domain

object CarRacing {
    fun initCars(carCount: Int): List<Car> {
        return (0 until carCount).map { Car() }
    }

    fun moveCars(listCar: List<Car>): List<Car> {
        return listCar.map { car ->
            val nextPosition = car.move(randomNumber())
            Car(position = nextPosition)
        }
    }

    private fun randomNumber() = (0..9).random()
}
