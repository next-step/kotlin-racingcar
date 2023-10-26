package game

class Car(var position: Int) {
    constructor() : this(0)

    fun move(movement: Int) {
        this.position += movement
    }
}
