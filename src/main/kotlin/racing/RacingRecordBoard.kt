package racing

import racing.model.Car
import racing.model.Driver
import racing.model.RacingResult

class RacingRecordBoard {
    private val _results: MutableList<RacingResult> = mutableListOf()
    val results: List<RacingResult>
        get() = _results.toList()

    val winners: List<Driver>
        get() {
            val result = this.lastResult.result
            val maxMileage = result.maxByMileage()
            return result.filter { it.mileage == maxMileage }.map { it.driver }
        }

    private val lastResult: RacingResult
        get() = results.lastOrNull() ?: throw IllegalArgumentException("레이싱 결과가 없습니다. 게임 먼저 해주세요.")

    fun add(result: List<Car>) = _results.add(RacingResult(result = result))

    private fun List<Car>.maxByMileage() =
        this.maxByOrNull { it.mileage }?.mileage ?: throw IllegalArgumentException("잘못된 입력값입니다. 입력값을 다시 확인해주세요.")
}
