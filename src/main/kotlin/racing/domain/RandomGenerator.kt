package racing.domain

class RandomGenerator {

    companion object {
        fun generate(): Int = (0..9).random()
    }
}
