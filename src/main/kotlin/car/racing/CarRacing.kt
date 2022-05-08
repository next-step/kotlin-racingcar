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

    companion object {
        private const val CAN_GO_FORWARD_MIN = 0
        private const val CAN_GO_FORWARD_MAX = 9
        private const val CAN_GO_FORWARD_THRESHOLD = 4
    }
}

class Game(
    drivers: Int,
    private val moves: Int
) {
    private val cars = List(drivers) { Car() }
    private val records = mutableListOf<List<Int>>()

    fun play(): List<List<Int>> {
        repeat(moves) {
            cars.forEach(Car::run)
            records.add(cars.map { it.moves })
        }
        return records
    }
}

class CarRacing {
    fun newGame(drivers: Int, moves: Int): Game {
        require(drivers > 0)
        require(moves > 0)
        return Game(drivers, moves)
    }
}
