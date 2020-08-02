package model

class Car(val driverName: String, step: Int = 0, val diceStatus: DiceStatus) : Comparable<Car> {
    private val stepListMutable = mutableListOf<Int>()
    val stepList: List<Int>
        get() {
            return stepListMutable.toList()
        }

    var step: Int = step
        private set

    fun move() {
        if (availableMove()) {
            step++
        }
        stepListMutable.add(step)
    }

    fun isWinner(value: Int): Boolean {
        return step == value
    }

    private fun availableMove(): Boolean {
        return diceStatus.isSuccess()
    }

    override fun compareTo(other: Car): Int {
        if (step == other.step) {
            return 0
        } else if (step < other.step) {
            return -1
        }
        return 1
    }
}
