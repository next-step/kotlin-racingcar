package racing.domain

import java.util.stream.IntStream
import kotlin.streams.toList

class ResultStatistics(private val cars: Cars) {

    fun toResult(): String {
        val stringBuilder = StringBuilder()
        for (car in cars) {
            stringBuilder.appendLine(toMark(car))
        }
        return stringBuilder.toString()
    }

    private fun toMark(car: Car): String {
        return IntStream.range(0, car.position)
            .mapToObj { MARK }
            .toList()
            .joinToString { "" }
    }

    companion object {
        const val MARK: String = "-"
    }
}
