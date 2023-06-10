package racing.domain

import java.util.Random

class Car(
    var position: Int = 0
) {

    fun moveCheck(): Boolean = Random().nextInt(10) >= 4

    fun move() {
        this.position = this.position.plus(1)
    }
}
