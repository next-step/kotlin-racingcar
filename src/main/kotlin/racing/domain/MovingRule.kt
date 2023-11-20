package racing.domain

interface MovingRule {
    val movingCount: Int
    fun isMove(): Boolean
}
