package car.racing

import kotlin.random.Random

class Car(
    private val forwardThreshold: Int = CAN_GO_FORWARD_THRESHOLD
) {
    private val random = Random(System.currentTimeMillis())

    private var _moves: Int = 0
    val moves: Int
        get() = _moves

    fun run() {
        if (canGoForward()) {
            _moves += 1
        }
    }

    private fun canGoForward(): Boolean {
        require(forwardThreshold in CAN_GO_FORWARD_MIN..CAN_GO_FORWARD_MAX)
        return random.nextInt(CAN_GO_FORWARD_MIN, CAN_GO_FORWARD_MAX) >= forwardThreshold
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
