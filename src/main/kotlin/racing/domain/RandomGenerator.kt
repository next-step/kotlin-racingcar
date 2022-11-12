package racing.domain

class RandomGenerator {

    companion object {
        fun generate(): Int = (1..9).random()
    }
}
