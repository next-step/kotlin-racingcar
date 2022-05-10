package step3.domain

class Car(private val engine: Engine) {
    var proceedLevel = INITIAL_PROCEED_LEVEL
        private set

    fun proceed() {
        proceedLevel += engine.getMovableDistance()
    }

    companion object {
        private const val INITIAL_PROCEED_LEVEL = 0
    }
}
