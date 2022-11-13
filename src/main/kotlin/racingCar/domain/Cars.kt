package racingCar.domain

class Cars(usernames: List<Username>, private val strategy: MoveStrategy) {

    val cars :Map<Username,Car> =  usernames.map { it to Car() }.toMap()

    fun moveByStrategy() {
        cars.forEach {
            moveByStrategy(it.value)
        }
    }

    private fun moveByStrategy(car: Car) {
        if (!strategy.canMove()) {
            return
        }
        car.move()
    }
}
