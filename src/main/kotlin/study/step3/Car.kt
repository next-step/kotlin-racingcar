package study.step3

class Car {

    private val _distance: StringBuilder = StringBuilder()
    val distance: String get() = _distance.toString()

    fun moveCar() {
        _distance.append(MOVE_CHARACTER)
    }

    companion object {
        private const val MOVE_CHARACTER = "-"
    }
}
