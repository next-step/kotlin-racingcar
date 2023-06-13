package racingcar

object CarFactory {
    fun manufacture(carNum: Int): List<Car> {
        val cars = mutableListOf<Car>()
        for (i in 0 until carNum) {
            cars.add(Car())
        }
        return cars
    }
}
