package racing.domain

class Car(val position: Int) {
    fun movePosition(): Car {
        return Car(position + 1)
    }
}
