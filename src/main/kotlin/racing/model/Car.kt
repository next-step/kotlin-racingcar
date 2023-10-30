package racing.model

import racing.model.move.MoveStrategy

data class Car(
    val name: String,
    val position: Int,
) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없다 : [$name] 은 [${name.length}] 자 입니다" }
    }

    private val velocity = 1
    fun move(moveStrategy: MoveStrategy): Car {
        if (moveStrategy.movable()) {
            return Car(name, position + velocity)
        }
        return this
    }
}
