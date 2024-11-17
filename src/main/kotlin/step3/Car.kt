package step3

class Car(
    val id: Int,
    var position: Int = 0,
) {
    fun forward() = position++
}
