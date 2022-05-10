package car.racing

class Game(drivers: Int, private val moves: Int) {
    private val cars = Cars(drivers)

    init {
        require(drivers > 0)
        require(moves > 0)
    }

    fun play(): GameRecords {
        val gameRecords = GameRecords()
        repeat(moves) {
            cars.runAll()
            gameRecords.record(cars)
        }
        return gameRecords
    }
}
