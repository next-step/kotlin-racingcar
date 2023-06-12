package study.step3

class Car {
    val stateList: MutableList<Int> = mutableListOf()
    private var state = 0

    fun move() {
        if (randomValue() >= MOVE_CONDITION) {
            state++
        }
        addCarState()
    }

    private fun addCarState() {
        stateList.add(state)
    }

    private fun randomValue() = (0..9).random()

    companion object {
        private const val MOVE_CONDITION = 4
    }
}
