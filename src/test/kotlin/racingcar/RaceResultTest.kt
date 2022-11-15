package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly

class RaceResultTest : StringSpec({
    "최종 기록을 반환한다" {
        val raceResult = RaceResult(
            records = listOf(
                Record(round = 1, name = Name("A"), position = Position.ZERO),
                Record(round = 2, name = Name("A"), position = Position(1)),
                Record(round = 3, name = Name("A"), position = Position(2)),
            )
        )

        raceResult.finalRecords().shouldContainExactly(Record(round = 3, name = Name("A"), position = Position(2)))
    }
})
