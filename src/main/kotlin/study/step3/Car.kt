package study.step3

class Car {
    private val states: MutableList<Int> = mutableListOf()
    private var state = 0

    fun move(condition: Int) {
        if (condition >= 4) {
            state++
        }
        addCarState()
    }

    private fun addCarState() {
        states.add(state)
    }

    fun getStateList(): List<Int> = states

    fun getStateByIndex(index: Int): Int = states[index]
}
