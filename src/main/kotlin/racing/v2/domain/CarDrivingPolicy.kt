package racing.v2.domain

class CarDrivingPolicy(val number: Int) : DrivingPolicy {
    override fun canForward(): Boolean {
        return number >= FORWARD_THRESHOLD
    }

    companion object {
        private const val FORWARD_THRESHOLD = 4
    }
}
