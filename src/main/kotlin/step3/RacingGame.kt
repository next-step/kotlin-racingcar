package step3

class RacingGame(private val cars: Cars) {
    private val positions: MutableList<Positions> = arrayListOf()

    constructor(cars: Int) : this(Cars(cars))

    fun play(playCount: Int) {
        for (i in 0 until playCount) {
            cars.drive()
            positions.add(cars.positions)
        }
    }

    fun positions(): List<Positions> = positions
}
