package racing

import racing.model.Car
import racing.model.RacingResult

class RacingRecordBoard {
    private val _results: MutableList<RacingResult> = mutableListOf()
    val results: List<RacingResult>
        get() = _results.toList()

    fun add(result: List<Car>) = _results.add(RacingResult(result = result))
}
