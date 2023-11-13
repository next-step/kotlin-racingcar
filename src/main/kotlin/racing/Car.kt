package racing

import kotlin.random.Random

open class Car(
    val name: String = "이름 없음"
) {
    var position: Int = INIT_POSITION
    
    fun move() {
        if (moveOrNot()) {
            position += POSITION_INCREMENT
        }
    }

    open fun moveOrNot(): Boolean {
        return Random.nextInt(RANDOM_LIMIT) > MOVE_POSITION_CONDITION
    }
    
    companion object {
        private const val INIT_POSITION = 0
        private const val POSITION_INCREMENT = 1
        private const val RANDOM_LIMIT = 10
        private const val MOVE_POSITION_CONDITION = 4
    }

}
