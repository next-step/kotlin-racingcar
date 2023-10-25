package racinggame

class Car(private var position: Int = 0) {

    fun forward() {
        position += 1
    }

    fun currentPosition(): Int = position
}