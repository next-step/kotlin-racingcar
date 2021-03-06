package racingcar

class RacingEngine(
    private val threshold: Force = DEFAULT_THRESHOLD,
    private val forceGenerator: ForceGenerator = DEFAULT_GENERATOR
) : Engine {
    override fun run(): Torque {
        if (exceedThreshold(forceGenerator.generate())) {
            return Torque.MOVE
        }

        return Torque.STOP
    }

    private fun exceedThreshold(force: Force): Boolean {
        return force >= threshold
    }

    companion object {
        private val DEFAULT_THRESHOLD = Force(4)
        private val DEFAULT_GENERATOR = RandomForceGenerator()
    }
}
