package racing.domain

class RandomGenerator {

    companion object {
        fun generate() = (0..9).random()
    }
}
