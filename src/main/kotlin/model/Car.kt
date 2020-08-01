package model

class Car(val driverName: String, step: Int = 0) : Comparable<Car> {
    private val stepListMutable = mutableListOf<Int>()
    val stepList: List<Int>
        get() {
            return stepListMutable.toList()
        }

    var step: Int = step
        private set

    fun move(availableMove: Boolean) {
        if (availableMove) {
            step++
        }
        stepListMutable.add(step)
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
