package racingcar

class Cars(private val cars: List<Car>) {
    fun findWinners(): Winners {
        val maxPosition = cars.maxBy { it.position }!!.position
        return Winners(cars.filter { it.position == maxPosition })
    }
}
