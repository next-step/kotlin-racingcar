package racingCar.ui

import racingCar.domain.Cars
import racingCar.domain.RaceResult

class RaceResultStorage(
    results: List<CarMove> = emptyList()
) : RaceResult {

    private val _results: MutableList<CarMove> = results.toMutableList()

    override fun save(cars: Cars) {
        val carMoves = cars.getPositions().map {
            CarMove(it.position)
        }
        ResultView.printRaceResult(carMoves)
        _results.addAll(carMoves)
        Thread.sleep(500) // 자동차 경주 사이의 결과를 0.5초씩 딜레이시켜 실시간으로 출력되는 것처럼 보이도록 만들기
    }

    val results
        get() = _results.toList()
}

data class CarMove(
    val position: Int,
)
