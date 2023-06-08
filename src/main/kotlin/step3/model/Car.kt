package step3.model

class Car(
    private val number: Int,
    private var position: Int = FIRST_POSITION
) {

    companion object {
        const val FIRST_POSITION = 1
    }

    fun move() {
        position += 1
    }

    fun getPosition(): Int {
        return position
    }
}
