package model

class Car(val diceStatus: DiceStatus, private val driverName: String) : Comparable<Car> {
    private var step: Int = 0
    private var stepList: MutableList<Int> = mutableListOf()

    fun getStep(): Int {
        return step
    }

    fun getDriverName(): String {
        return driverName
    }

    fun getStepList(): MutableList<Int> {
        return stepList
    }

    fun diceMove() {
        if (diceStatus.availableMove(diceStatus.dice())) {
            step++
        }
        stepList.add(step)
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
