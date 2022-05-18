package raicing.processor

import raicing.model.RaceCar
import raicing.model.RaceResult
import raicing.strategy.CarMovingStrategy

class RaceProcessor {

    fun race(initRaceCar: RaceCar, raceCount: Int): RaceResult {
        val raceCars = mutableListOf<RaceCar>()

        repeat(raceCount) {
            // 직전 경기 결과
            val raceCar = raceCars.lastOrNull() ?: initRaceCar
            // 경기 1회 진행
            val raceResult = raceCar.raceOnce(CarMovingStrategy)
            // 경기 결과 리스트에 추가
            raceCars += raceResult
        }

        return RaceResult(raceCars)
    }
}
