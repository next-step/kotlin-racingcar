package study.step3

class Car {
    val stateList: MutableList<Int> = mutableListOf()
    private var state = 0

    fun move(moveCondition: Boolean) {
        if (moveCondition) {
            state++
        }
        addCarState()
    }

    private fun addCarState() {
        stateList.add(state)
    }
}
