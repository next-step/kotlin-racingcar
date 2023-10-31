package camp.nextstep.edu.step.racing.domain

import camp.nextstep.edu.step.racing.strategy.CarMoveStrategy

data class Car(
    val carName: String,
    var position: Int = 0
) {
    init {
        require(carName.isNotBlank()) { "자동차의 이름이 비어있습니다." }
    }

    fun moveForward(carMoveStrategy: CarMoveStrategy) {
        val carMoveStatus = carMoveStrategy.isMovable()

        if (carMoveStatus) {
            this.position += 1
        }
    }

}
