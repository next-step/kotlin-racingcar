package racing.v2.domain

object CarDrivingPolicy : DrivingPolicy {
    private const val FORWARD_THRESHOLD = 4
    
    override fun canForward(number: Int): Boolean {
        return number >= FORWARD_THRESHOLD
    }
}
