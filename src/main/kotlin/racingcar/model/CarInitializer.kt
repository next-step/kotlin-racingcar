package racingcar.model

object CarInitializer {
    fun createCars(numbersOfCar: Int): List<Car> = List(numbersOfCar) { Car(it.toString()) }
}
