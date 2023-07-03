package domain

interface Engine {
    fun getRandomNumber(): Int
    fun isMoving(number: Int): Boolean
}
