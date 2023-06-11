package step3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : FreeSpec(
    {
        "이동 명령을 수행하면 위치를 이동한다 - 엔진 쟉동 성공" {
            forAll(
                row(1),
                row(1000)
            ) { moveCount ->
                val sut = Car(ConditionalOperatingCarEngine { true }, "test")

                repeat(moveCount) { sut.move() }

                sut.movedDistance shouldBe Distance(moveCount)
            }
        }

        "이동 명령을 수행하면 위치를 이동한다 - 엔진 쟉동 실패" {
            forAll(
                row(1),
                row(1000)
            ) { moveCount ->
                val sut = Car(ConditionalOperatingCarEngine { false }, "test")

                repeat(moveCount) { sut.move() }

                sut.movedDistance shouldBe Distance(0)
            }
        }
    }
)
