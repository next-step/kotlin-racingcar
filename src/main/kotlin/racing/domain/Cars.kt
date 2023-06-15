package racing.domain

@JvmInline
value class Cars(
    private val cars: List<Car>,
) : List<Car> by cars {
    fun play(movePolicy: MovePolicy) {
        cars.forEach {
            it.move(movePolicy)
        }
    }

    fun getWinners(): List<String> {
        val winner = cars.maxByOrNull { it.position } ?: return emptyList()
        return cars.filter { it.hasSamePosition(winner) }
            .map { it.name }
    }

    companion object {
        fun of(carNames: List<String>): Cars {
            return Cars(carNames.map { Car(it) })
        }
    }
}
