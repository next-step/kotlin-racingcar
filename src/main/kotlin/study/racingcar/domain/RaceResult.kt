package study.racingcar.domain

import study.racingcar.common.GameConfig

class RaceResult(private val cars: List<Car>) {
    val resultSymbols: List<String> = cars.map { toRaceSymbol(it) }

    private fun toRaceSymbol(car: Car): String {
        return (1..car.moveCount).map { GameConfig.RACE_SYMBOL }.joinToString("")
    }
}
