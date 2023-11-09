package racing.v2.domain

class CarDrivingPolicy(private val generator: NumberGenerator = RandomNumberGenerator) : DrivingPolicy {
    override fun canForward(): Boolean {
        return generator.generate(UPPER_BOUND) >= FORWARD_THRESHOLD
    }

    companion object {
        private const val FORWARD_THRESHOLD = 4
        private const val UPPER_BOUND = 10
    }
}
