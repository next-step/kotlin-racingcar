package racingcar.domain

class CarMaker {
    fun make(numberOfCar: Int): MutableList<Car> {
        val cars = mutableListOf<Car>()
        for (i in 0 until numberOfCar) {
            cars.add(Car())
        }
        return cars
    }
}
