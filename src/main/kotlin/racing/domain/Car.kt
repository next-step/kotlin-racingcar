package racing.domain

import racing.generator.DefaultRandomMoveCheckGenerator

class Car(
    var position: Int = 0,
    val moveFlag: DefaultRandomMoveCheckGenerator
) {

    fun moveCheck(): Boolean = this.moveFlag.moveCheck(10)

    fun move() {
        this.position = this.position.plus(1)
    }
}
