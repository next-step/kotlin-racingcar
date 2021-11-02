package racingcar.car

object CarsFactory {
    fun create(carsName: String): Cars {
        return Cars(carsName)
    }
}
