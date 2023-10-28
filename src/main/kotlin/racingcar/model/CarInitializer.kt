package racingcar.model

object CarInitializer {
    fun createCars(numbersOfCar: Int): List<Car> {
        val cars = arrayListOf<Car>()
        for (i in 1..numbersOfCar) {
            cars.add(Car(i.toString()))
        }
        return cars
    }
}
