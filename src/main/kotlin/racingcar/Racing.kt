package racingcar

class Racing(private val cars: Cars) {

    private val _racing = mutableListOf<Cars>()

    val result: List<Cars>
        get() = _racing

    fun start(roundCount: Int, moveStrategy: MoveStrategy) {

        repeat(roundCount) {
            val racingCars = if (_racing.isNotEmpty()) _racing.last() else cars
            _racing.add(racingCars.move(moveStrategy))
        }
    }
}
