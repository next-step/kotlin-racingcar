package game

class Car(var position: Int = 0) {

    fun move(movement: Int) {
        this.position += movement
    }
}
