package car.racing

import kotlin.random.Random

class InputView(
    private val reader: () -> String?,
    private val console: (String) -> Unit
) {

    fun readDrivers(): Int {
        console("자동차 대수는 몇 대인가요?: ")
        return readInt()
    }

    fun readMoves(): Int {
        console("시도할 횟수는 몇 회인가요?: ")
        return readInt()
    }

    private fun readInt(): Int {
        val value: String? = reader()
        requireNotNull(value)
        return kotlin
            .runCatching { value.toInt() }
            .getOrElse { throw IllegalArgumentException() }
    }
}

class ResultView(
    private val console: (String) -> Unit
) {
    fun showRecords(records: List<List<Int>>) {
        console("실행 결과:\n")
        records.forEach(::showRecord)
    }

    private fun showRecord(record: List<Int>) {
        record.forEach { move ->
            repeat(move) {
                console(DISPLAY_MOVEMENT)
            }
            showEmptyLine()
        }
        showEmptyLine()
    }

    private fun showEmptyLine() = console("\n")

    companion object {
        private const val DISPLAY_MOVEMENT = "-"
    }
}

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

fun main() {
    val inputView = InputView(::readLine, ::print)
    val drivers = inputView.readDrivers()
    val moves = inputView.readMoves()

    val game = CarRacing().newGame(drivers, moves)
    val records = game.play()

    val resultView = ResultView(::print)
    resultView.showRecords(records)
}
