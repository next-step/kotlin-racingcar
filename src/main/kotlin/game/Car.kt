package game

class Car(var position: Int) {
    fun move(movement: Int) {
        this.position += movement
    }
}
