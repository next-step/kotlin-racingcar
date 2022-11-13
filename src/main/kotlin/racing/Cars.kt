package racing

data class Cars(private val cars: List<Car>) {
    companion object {
        fun init(numberOfCars: Int, moveStrategy: MoveStrategy): Cars {
            val carList = (0.until(numberOfCars)).map { Car(moveStrategy = moveStrategy) }
            return Cars(carList)
        }
    }

    fun move() {
        cars.forEach(Car::move)
    }

    fun getDistances(): List<Int> {
        return cars.map(Car::distance)
    }
}
