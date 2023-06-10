package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ConditionalOperatingCarEngineTest : FreeSpec(
    {
        "조건부로 작동에 성공한다." {
            forAll(
                row({ true }, Distance(1)),
                row({ false }, Distance(0))
            ) { conditionChecker, expectedDistance ->

                val sut = ConditionalOperatingCarEngine(conditionChecker)

                val movedDistance = sut.move()

                movedDistance shouldBe expectedDistance
            }
        }
    }
)


