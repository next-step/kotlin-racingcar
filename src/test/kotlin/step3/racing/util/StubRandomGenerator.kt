package step3.racing.util

class StubRandomGenerator(private val result: MutableList<Int>) : RandomGenerator() {
    override fun getInt(range: IntRange): Int {
        try {
            return result.removeFirst()
        } catch (e: Throwable) {
            throw NoSuchElementException("주어진 값을 전부 사용했습니다.")
        }
    }
}
