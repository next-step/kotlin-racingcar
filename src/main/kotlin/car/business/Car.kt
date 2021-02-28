package car.business

class Car {
    protected var position: Int = 0
    fun move(rand: Int): Boolean {
        if(!isMovable(rand)) return false

        position++
        return false;
    }
    private fun isMovable(rand: Int): Boolean {
        return rand >= 4
    }
}