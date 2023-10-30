package racing

class DrivingPolicy {
    companion object {
        private const val FORWARD_THRESHOLD = 4

        fun canMoveForward(number: Int): Boolean {
            return number >= FORWARD_THRESHOLD
        }
    }
}
