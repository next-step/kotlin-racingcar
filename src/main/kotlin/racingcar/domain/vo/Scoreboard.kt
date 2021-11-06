package racingcar.domain.vo

import racingcar.domain.RacingCars

@JvmInline
value class Scoreboard(
    private val value: Map<Lap, RacingCars> = mapOf()
) {
    fun record(lap: Lap, racingCars: RacingCars): Scoreboard {
        val scoreboard = value.toMutableMap()
        scoreboard[lap] = racingCars
        return Scoreboard(scoreboard)
    }

    fun laps(): Laps {
        return Laps.of(value.keys)
    }

    fun snapshotOf(lap: Lap): RacingCars {
        return value[lap] ?: throw IllegalArgumentException("존재하지 않는 Lap 입니다.")
    }

    companion object {
        fun initialize(racingCars: RacingCars): Scoreboard {
            return Scoreboard(mapOf(Lap.initialize() to racingCars))
        }
    }
}
