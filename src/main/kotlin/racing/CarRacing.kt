package racing

object CarRacing {
    fun createCars(carCount: Int) = List(carCount) { Car() }

    fun race(tryCount: Int, carCount: Int): List<List<String>> {
        val cars = createCars(carCount)
        return List(tryCount) {
            cars.forEach { car ->
                car.moveOrStop()
            }
            cars.map { it.getResult() }
        }
    }
}
