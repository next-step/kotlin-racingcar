package car.business

class Car {
    internal var position: Int = 0
    private set

    fun move(rand: Int): Boolean {
        if(!isMovable(rand)) return false

        position++
        return true;
    }
    private fun isMovable(rand: Int): Boolean {
        return rand >= 4
    }
}