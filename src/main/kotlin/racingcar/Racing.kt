package racingcar

class Racing(cars: Cars) {

    private val racing = mutableListOf<Cars>()

    init {
        racing.add(cars)
    }

    fun start(roundCount: Int, moveStrategy: MoveStrategy) {
        for (j in 0 until roundCount) {
            val racingCars = racing.last()
            racing.add(racingCars.move(moveStrategy))
        }
    }

    fun result() = racing.toList()
}
