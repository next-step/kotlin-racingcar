package race

class Car(
    private val moveCondition: MoveCondition
) {

    var position: Int = 0
        private set

    fun copyRecord(): CarRecord {
        return CarRecord(position)
    }

    fun move() {
        if (moveCondition.canGoStraight()) {
            straight()
        }
    }

    private fun straight() {
        position++
    }
}
