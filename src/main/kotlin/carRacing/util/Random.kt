package carRacing.util

interface Random {

    fun value(): Int

    class RandomGenerator : Random {
        override fun value(): Int = kotlin.random.Random.nextInt(MIN, MAX)

        companion object {
            private const val MIN = 0
            private const val MAX = 9
        }
    }

    class TestRandomGenerator(
        private val testValue: Int
    ) : Random {
        override fun value(): Int = testValue

        companion object {
            const val TEST_DEFAULT_VALUE = 5
        }
    }
}
