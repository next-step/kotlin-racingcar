package domain

class Race {
    fun carRace(car: Car, isMoving: Boolean): Int = car.move(isMoving)
}
