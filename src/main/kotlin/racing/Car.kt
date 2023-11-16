package racing

open class Car(
    val name: String = DEFAULT_NAME
) {
    var position: Int = INIT_POSITION
        private set
    
    fun move(condition: Int) {
        if (condition > MOVE_POSITION_CONDITION) {
            position += POSITION_INCREMENT
        }
    }

    companion object {
        private const val INIT_POSITION = 0
        private const val POSITION_INCREMENT = 1
        private const val MOVE_POSITION_CONDITION = 4
        private const val DEFAULT_NAME = "이름 없음"
    }

}
