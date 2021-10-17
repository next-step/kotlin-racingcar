package domain.step3.domain.game

import domain.step3.domain.racingcar.RacingCars

@JvmInline
value class GameRecord(private val gameRecord: List<RacingCars>) {
    init {
        require(gameRecord.isNotEmpty()) { EMPTY_MESSAGE }
    }

    fun add(racingCars: RacingCars): GameRecord {
        val mutableGameRecord = gameRecord.toMutableList()
        mutableGameRecord.add(racingCars)
        return GameRecord(mutableGameRecord)
    }

    companion object {
        const val EMPTY_MESSAGE = "비어있는 값은 들어올 수 없습니다."

        fun initialize(racingCars: RacingCars) = GameRecord(listOf(racingCars))
    }
}