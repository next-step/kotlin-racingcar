package car.business

class Car {
    private var position: Int = 0;
    fun move(rand: Int): Boolean {
        if(!isMovable(rand)) return false;

        position++;
        return false;
    }
    private fun isMovable(rand: Int): Boolean {
        if(rand >= 4) return true
        return false;
    }
}