package racing

class RandomNumberGenerator {
    companion object {
        fun generate(from: Int, to: Int): Int {
            return (from..to).random()
        }
    }
}
