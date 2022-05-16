package racing.domain

class Car(
    val name: String,
) {
    var position: Int
        private set

    init {
        position = DEFAULT_POSITION
    }

    fun movePosition() {
        position += 1
    }

    companion object{
        const val DEFAULT_POSITION: Int = 0
    }

}
