package car.business

class Car {
    internal var position: Int = 0
        private set

    fun move(rand: Int): Boolean {
        if (!isMovable(rand)) return false

        position++
        return true
    }
    private fun isMovable(rand: Int): Boolean {
        return rand >= MOVE_BIGGER_THAN
    }
    companion object {
        val MOVE_BIGGER_THAN = 4
    }
}
