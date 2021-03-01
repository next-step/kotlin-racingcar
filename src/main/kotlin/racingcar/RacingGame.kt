package racingcar

class RacingGame(private val cars: Cars) {
    private val _positions: MutableList<Positions> = arrayListOf()
    val positions: List<Positions>
        get() = _positions

    constructor(cars: Int) : this(Cars(cars))

    fun play(playCount: Int) {
        repeat(playCount) {
            cars.drive()
            _positions.add(cars.positions)
        }
    }
}
