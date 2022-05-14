package racing

data class Car(
    val number: Int,
    var currentLocation: Int = 0,
) {
    fun move() {
        this.currentLocation++
    }
}
