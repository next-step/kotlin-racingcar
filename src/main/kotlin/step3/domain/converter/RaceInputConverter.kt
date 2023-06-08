package step3.domain.converter

import step3.domain.game.RaceGameInfo
import kotlin.jvm.Throws

object RaceInputConverter {

    @Throws(IllegalArgumentException::class)
    fun convertRaceGameInfo(carCountInputString: String, roundInputString: String): RaceGameInfo = RaceGameInfo(
        carCount = requireNotNull(value = carCountInputString.toIntOrNull()),
        round = requireNotNull(value = roundInputString.toIntOrNull()),
    )
}
