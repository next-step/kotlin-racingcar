package random

object RandomNumberGenerator {
    fun generate(from: Int, to: Int): Int {
        return (from..to).random()
    }
}
