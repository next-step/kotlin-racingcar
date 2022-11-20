package race

class Car {
    fun move(randomNumber: Int): Boolean {
        return randomNumber >= THRESHOLD
    }

    companion object {
        private const val THRESHOLD = 4
    }
}
