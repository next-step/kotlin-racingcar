package racing.model

interface Engine {
    val forwardLimit: Int
    fun canMoveForward(): Boolean
}