package step3.model

class Car {
    var proceedLevel = INITIAL_PROCEED_LEVEL
        private set

    fun proceed() {
        proceedLevel += 1
    }

    companion object {
        private const val INITIAL_PROCEED_LEVEL = 0
    }
}
