package racingcar.model

/**
 * 현재는 자동차를 index 기반으로 생성하고 있지만
 * 자동차들을 외부에서 주입받아 처리하려면 추상화를 통해 여러개의 Cars 구현체로 가능할 듯
 */
data class Cars(private var cars: List<Car>) {

    init {
        checkCarsMinimumSize(cars.size)
    }

    private fun checkCarsMinimumSize(size: Int) {
        require(size > 0) {
            "at least 1 size required"
        }
    }

    val size: Int get() = cars.size

    fun move() {
        this.cars = cars.map { car -> car.tryMove() }
    }

    fun filterWinners(): Cars {
        val maxPosition = getMaxPosition()
        val winnerCars = cars.filter { it.position == maxPosition }
        return Cars(winnerCars)
    }

    private fun getMaxPosition(): Int = cars.maxOf { it.position }

    fun forEach(action: (Car) -> Unit) = cars.forEach(action)

    fun joinToString(
        separator: CharSequence = ", ",
        transform: ((Car) -> CharSequence)? = null
    ): String = cars.joinToString(separator = separator, transform = transform)
}
