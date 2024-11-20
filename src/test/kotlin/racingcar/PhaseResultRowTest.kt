package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PhaseResultRowTest : StringSpec({
    "row에 하나의 값을 추가할 수 있다." {
        val row = PhaseResultRow()
        row.addResult(1)

        row.getPhaseRecord(0) shouldBe 1
    }

    "row의 특정 위치에 있는 값을 가져올 수 있다." {
        val row = PhaseResultRow()
        row.addResult(1)
        row.addResult(2)

        row.getPhaseRecord(1) shouldBe 2
    }

    "row에 포함된 값 중 최대값을 가져올 수 있다." {
        val row = PhaseResultRow()
        row.addResult(1)
        row.addResult(2)

        row.getMax() shouldBe 2
    }
})
