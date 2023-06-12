package step3.domain

import step3.domain.strategy.CarMovingCondition
import step3.domain.strategy.RandomMoveCondition

/**
 * ### 레이싱 요청 값 중 자동에 대한 스펙을 표현하는 data 클래스 입니다.
 */
data class CarRequest(
    val name: String,
    val carMovingCondition: CarMovingCondition = RandomMoveCondition.default()
)
