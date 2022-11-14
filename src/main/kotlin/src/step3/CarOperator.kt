package src.step3

object CarOperator {

    fun calculateCarMoveDistance(carNumber: Int, tryCount: Int): MutableList<Car> {
        val cars = mutableListOf<Car>()
        makeCar(cars, carNumber)

        for (car in cars) {
            car.move(tryCount, getCarMoveRandomValue())
        }

        return cars
    }

    private fun makeCar(cars: MutableList<Car>, carNumber: Int) {
        for (i in 0 until carNumber) {
            cars.add(Car())
        }
    }
}
