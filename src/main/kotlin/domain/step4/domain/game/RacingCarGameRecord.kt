package domain.step4.domain.game

import domain.step4.domain.racingcar.RacingCars

data class RacingCarGameRecord private constructor(private val _racingCarGameRecord: List<RacingCars>) {
    val racingCarGameRecord: List<RacingCars>
        get() = _racingCarGameRecord.toList()

    fun add(racingCars: RacingCars): RacingCarGameRecord =
        RacingCarGameRecord(_racingCarGameRecord + racingCars)

    companion object {
        fun initialize(): RacingCarGameRecord =
            RacingCarGameRecord(listOf())

        fun of(racingCarGameRecord: List<RacingCars>): RacingCarGameRecord =
            RacingCarGameRecord(racingCarGameRecord.toList())
    }
}