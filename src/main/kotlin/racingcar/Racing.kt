package racingcar

class Racing(private val cars: Cars) {

    private val racing = mutableListOf<Cars>()

    fun start(roundCount: Int, moveStrategy: MoveStrategy) {
        for (j in 0 until roundCount) {
            val racingCars = if (racing.isNotEmpty()) racing.last() else cars
            racing.add(racingCars.move(moveStrategy))
        }
    }

    fun result() = racing.toList()
}
