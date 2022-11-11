package step3.domain

data class Cars(val car: List<Car>) {
    private val cars = car

    init {
        require(cars.isNotEmpty()) { "자동차는 1대 이상이어야 합니다." }
    }

    fun play() {
        cars.forEach { it.move(Utils.generateRandomNumber(Utils.RANDOM_NUMBER_START_INDEX, Utils.RANDOM_NUMBER_END_INDEX)) }
    }

    fun getPositions(): List<Position> {
        return cars.map { it.position }
    }
}
