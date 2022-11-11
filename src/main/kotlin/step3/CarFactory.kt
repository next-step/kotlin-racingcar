package step3

class CarFactory {
    fun create(numberOfCars: Int): List<Car> {
        val cars: MutableList<Car> = mutableListOf()

        for (i in 1..numberOfCars) {
            cars.add(Car())
        }

        return cars
    }
}
