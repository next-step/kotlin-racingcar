package racingcar

class RacingEngine(
    private val threshold: Force = Force(4),
    private val forceGenerator: ForceGenerator = DEFAULT_GENERATOR
) : Engine {
    init {
        require(threshold >= Force.ZERO) { "Threshold must be positive or zero." }
    }

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
        private val DEFAULT_GENERATOR = RandomForceGenerator()
    }
}
