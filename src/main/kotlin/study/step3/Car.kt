package study.step3

class Car(
    private val movementConditionGenerator: MovementConditionGenerator
) {
    private var trace: String = ""

    fun move() {
        val condition = movementConditionGenerator.run()
        if (condition >= 4) {
            trace += "-"
        }
    }

    fun getMovementTrace() = trace
}
