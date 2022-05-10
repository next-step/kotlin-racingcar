package car.racing

class Game(drivers: Int, private val moves: Int) {
    private val cars = Cars(drivers)
    private val gameRecords = GameRecords()

    init {
        require(drivers > 0)
        require(moves > 0)
    }

    fun play(): GameRecords {
        gameRecords.reset()
        repeat(moves) {
            cars.runAll()
            gameRecords.record(cars)
        }
        return gameRecords
    }
}
