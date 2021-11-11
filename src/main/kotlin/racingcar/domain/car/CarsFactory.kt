package racingcar.domain.car

object CarsFactory {
    fun create(carsName: String): Cars {
        return Cars(carsName)
    }
}
