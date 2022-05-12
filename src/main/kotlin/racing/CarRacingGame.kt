package racing

import racing.domain.Car

class CarRacingGame(private val carCount: Int, private val times: Int) {
    private val carPositionHistory: LinkedHashMap<Car, MutableList<Int>>

    init {
        carPositionHistory = initCarPositionHistory()
    }

    fun start(): LinkedHashMap<Car, MutableList<Int>> {
        repeat(times) {
            moveCars()
            saveCarPosition()
        }
        return carPositionHistory
    }

    private fun initCarPositionHistory(): LinkedHashMap<Car, MutableList<Int>> {
        val tmpCarPositionHistory = LinkedHashMap<Car, MutableList<Int>>()
        repeat(carCount) {
            tmpCarPositionHistory[Car(START_POSITION, RandomMoving())] = mutableListOf()
        }
        return tmpCarPositionHistory
    }

    private fun moveCars() {
        carPositionHistory.keys.forEach { car ->
            car.move()
        }
    }

    private fun saveCarPosition() {
        carPositionHistory.forEach { (car, history) ->
            car.savePosition(history)
        }
    }

    companion object {
        const val START_POSITION = 0
    }
}
