package racing.domain

@JvmInline
value class Cars private constructor(val cars: List<Car>) {
    fun goForward(pedal: Pedal): RoundResult {
        cars.forEach { it.moveForward(pedal) }
        return RoundResult(cars)
    }

    fun getWinners(): List<Car> {
        val max = cars.maxOf(Car::position)
        return cars.filter { it.position == max }
            .toList()
    }

    companion object {
        fun make(carNames: List<String>): Cars {
            require(carNames.isNotEmpty()) {
                "1개 이상 이름이 필요합니다."
            }
            return Cars(carNames.map(::Car))
        }
    }
}
