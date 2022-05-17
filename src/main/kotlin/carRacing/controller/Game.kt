package carRacing.controller

import carRacing.model.Car
import carRacing.model.Record
import carRacing.util.RandomGenerator

class Game(
    carNameList: List<String>,
    private val numMovement: Int,
) {

    init {
        require(carNameList.isNotEmpty()) { INVALID_CAR_LIST }
        require(numMovement >= 1) { INVALID_NUM_MOVEMENT }
    }

    private val _recordList: MutableList<Record> = mutableListOf()
    val recordList: List<Record> get() = _recordList

    private val cars: List<Car> = carNameList.map { Car(it) }

    private fun runRound() {
        this.cars.forEach {
            val randomValue: Int = RandomGenerator.value()
            if (randomValue >= MOVE_ACTION_MIN) it.move()
        }
    }

    fun run() {
        repeat(this.numMovement) {
            this.runRound()
            this._recordList.add(
                Record(this.cars.map { it.position })
            )
        }
    }

    fun winner(): List<Car> {
        val car = cars.maxOrNull() ?: throw IllegalStateException(INVALID_CAR_LIST)
        return this.cars.filter { it.isDrawWith(car) }
    }

    companion object {
        private const val MOVE_ACTION_MIN = 4
        const val INVALID_CAR_LIST = "자동차 수는 1이상 이어야한다."
        const val INVALID_NUM_MOVEMENT = "시도 횟수는 1이상 이어야한다."
    }
}
