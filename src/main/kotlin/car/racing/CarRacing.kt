package car.racing

enum class CarCondition(private val threshold: Int) {
    GOOD(0),
    NORMAL(4),
    BAD(9),
    TERRIBLE(10);

    fun canGoForward(): Boolean = thresholdRange.random() >= threshold

    companion object {
        private val thresholdRange = GOOD.threshold..BAD.threshold
    }
}

class Car(private val condition: CarCondition = CarCondition.NORMAL) {

    private var _moves: Int = 0
    val moves: Int
        get() = _moves

    fun run() {
        if (condition.canGoForward()) {
            _moves += 1
        }
    }
}

class Cars(drivers: Int) {
    private val cars = List(size = drivers) { Car() }
    fun getAllMove(): List<Int> = cars.map { it.moves }
    fun runAll(): Unit = cars.forEach(Car::run)
}

class GameRecords {
    private val _records = mutableListOf<List<Int>>()
    val records: List<List<Int>>
        get() = _records

    fun record(cars: Cars): Boolean = _records.add(cars.getAllMove())
    fun reset(): Unit = _records.clear()
}

class Game(drivers: Int, private val moves: Int) {
    private val cars = Cars(drivers)
    private val gameRecords = GameRecords()

    fun play(): GameRecords {
        gameRecords.reset()
        repeat(moves) {
            cars.runAll()
            gameRecords.record(cars)
        }
        return gameRecords
    }
}

class CarRacing {
    fun newGame(drivers: Int, moves: Int): Game {
        require(drivers > 0)
        require(moves > 0)
        return Game(drivers, moves)
    }
}
