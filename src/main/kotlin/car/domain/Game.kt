package car.domain

class Game(driverNames: List<String>, private val moves: Int) {
    private val cars = Cars(driverNames)

    init {
        require(driverNames.isNotEmpty())
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
