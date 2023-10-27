package racing

import org.assertj.core.util.VisibleForTesting

object InputView {
    fun inputForRacing(): List<List<Car>> {
        val carCount = read("자동차 대수는 몇 대인가요?")
        val tryCount = read("시도할 횟수는 몇 회인가요?")
        return create(tryCount, carCount)
    }

    private fun read(question: String): Int {
        println(question)
        return readln().toInt()
    }

    @VisibleForTesting
    fun create(tryCount: Int, carCount: Int) = List(tryCount) { List(carCount) { Car() } }
}
