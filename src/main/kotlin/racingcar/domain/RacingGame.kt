package racingcar.domain

class RacingGame(private val cars: Cars) {
    private val _positions: MutableList<Positions> = arrayListOf()
    val positions: List<Positions>
        get() = _positions

    constructor(names: List<Name>) : this(Cars(names.toTypedArray()))

    fun play(playCount: Int) {
        repeat(playCount) {
            cars.drive()
            _positions.add(cars.positions)
        }
    }

    fun winner() = Winner(positions)
}
