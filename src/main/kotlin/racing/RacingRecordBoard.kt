package racing

import racing.model.Car

class RacingRecordBoard {
    private val _results: MutableList<List<Car>> = mutableListOf()
    val results: List<List<Car>>
        get() = _results.toList()

    fun add(result: List<Car>) = _results.add(result)
}
