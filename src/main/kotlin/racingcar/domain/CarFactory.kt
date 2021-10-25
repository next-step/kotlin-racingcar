package racingcar.domain

object CarFactory {
    fun createCars(carNameList: List<String>): List<Car> = (carNameList).map { Car(it) }
}
