package game

class Car(var position: Int = 0) {

    fun move(moveCondition: Int) {
        when {
            canMove(moveCondition) -> advance()
        }
    }

    private fun advance() {
        position += 1
    }

    private fun canMove(moveCondition: Int) = moveCondition in 4..9
}
