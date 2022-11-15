package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class RaceResultTest : StringSpec({
    "라운드별 기록을 반환한다" {
        val raceResult = RaceResult(
            records = listOf(
                Record(round = 1, name = Name("A"), position = Position.ZERO),
                Record(round = 2, name = Name("A"), position = Position(1)),
                Record(round = 3, name = Name("A"), position = Position(2)),
            )
        )

        val map = raceResult.toMap()

        map.keys shouldContainExactly setOf(1, 2, 3)
        listOf(*map.keys.toTypedArray()).forAll {
            it shouldBe map[it]?.first()?.round
        }
    }
})
