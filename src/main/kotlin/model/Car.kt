package model

class Car(val driverName: String) : Comparable<Car> {
    var step: Int = 0
        private set
    private var stepList: MutableList<Int> = mutableListOf()

    fun getStepList(): MutableList<Int> {
        return stepList
    }

    fun move(availableMove: Boolean) {
        if (availableMove) {
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
