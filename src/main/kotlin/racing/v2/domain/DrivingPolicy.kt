package racing.v2.domain

interface DrivingPolicy {
    fun canForward(number: Int): Boolean
}
