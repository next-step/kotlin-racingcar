package racing.domain

import kotlin.streams.asSequence

class ResultStatistics(private val cars: Cars) {

    fun toResult(): String {
        val stringBuilder = StringBuilder()
        for (car in cars) {
            stringBuilder.appendLine(car.routes().stream().map { "-" }.asSequence().joinToString(""))
        }
        return stringBuilder.toString()
    }
}
