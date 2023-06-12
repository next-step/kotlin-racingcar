package racing.car

data class Car(
    private var name: String = "",
    private var position: Int = 0
) {

    fun move() {
        this.position += 1
    }

    fun getPosition(): Int {
        return this.position
    }
}
