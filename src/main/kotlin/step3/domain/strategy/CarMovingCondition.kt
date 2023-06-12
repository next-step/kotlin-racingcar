package step3.domain.strategy

import kotlin.random.Random

/**
 * ### 자동차를 전진시킬 수 있는 다양한 조건을 추상화한 인터페이스 입니다.
 */
interface CarMovingCondition {
    fun canMove(): Boolean
}

class AlwaysMoveCondition : CarMovingCondition {
    override fun canMove(): Boolean {
        return true
    }
}

class NeverMoveCondition : CarMovingCondition {
    override fun canMove(): Boolean {
        return false
    }
}

/**
 * ### 무작위 값에 의해 전진이 결정되는 Condition 입니다.
 *
 * 무작위 값이 threshold 이상일때 전진 가능 하며
 * 무작위 값은 닫힌 구간인 boundFrom 부터 열린 구간인 boundUntil 사이의 값으로 결정됩니다.
 */
class RandomMoveCondition(
    private val threshold: Int,
    private val boundFrom: Int,
    private val boundUntil: Int,
) : CarMovingCondition {
    override fun canMove(): Boolean {
        return Random.nextInt(boundFrom, boundUntil) >= threshold
    }
}
