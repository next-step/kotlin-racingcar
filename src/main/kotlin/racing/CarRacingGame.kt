package racing

class CarRacingGame(private val carCount: Int, private val times: Int) {
    private val carPositionHistory: LinkedHashMap<Car, MutableList<Int>>

    init {
        carPositionHistory = initCarPositionHistory()
    }

    fun getGameResult(): LinkedHashMap<Car, MutableList<Int>> {
        repeat(times) {
            moveCars()
            saveCarPosition()
        }
        return carPositionHistory
    }

    private fun initCarPositionHistory(): LinkedHashMap<Car, MutableList<Int>> {
        val tmpCarPositionHistory = LinkedHashMap<Car, MutableList<Int>>()
        repeat(carCount) {
            tmpCarPositionHistory[Car()] = mutableListOf()
        }
        return tmpCarPositionHistory
    }

    private fun moveCars() {
        carPositionHistory.keys.forEach { car ->
            car.move(RandomGenerator.generate())
        }
    }

    private fun saveCarPosition() {
        carPositionHistory.forEach { (car, history) ->
            history.add(car.position)
        }
    }
}
