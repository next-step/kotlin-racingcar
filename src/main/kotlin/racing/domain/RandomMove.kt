package racing.domain

class RandomMove(
    private val minimumRandomNumber: Int = 0,
    private val maximumRandomNumber: Int = 9,
    private val movingReferencePoint: Int = 4
) : Movable {

    init {
        require(minimumRandomNumber < maximumRandomNumber) { "최소 랜덤 숫자는 최대 랜덤 숫자보다 작아야 합니다." }
    }

    override fun canMoveIt(): Boolean {
        return (minimumRandomNumber..maximumRandomNumber).random() >= movingReferencePoint
    }
}
