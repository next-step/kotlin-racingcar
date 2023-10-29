package racingcar.domain

data class MoveCondition(
    val strategy: MoveStrategy,
    val moveCnt: Int = 0
)