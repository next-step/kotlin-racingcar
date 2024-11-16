package racingcar

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarActionTest : StringSpec({
    "0에서 3는 정지, 4에서 9는 전진을 반환한다." {
        forAll(
            row(0, CarAction.STAND),
            row(3, CarAction.STAND),
            row(4, CarAction.MOVE),
            row(9, CarAction.MOVE),
        ) { number, expectedAction ->
            CarAction.generate(number) shouldBe expectedAction
        }
    }

    "0에서 9 사이의 숫자가 아닌 경우 예외를 던진다." {
        forAll(
            row(-1),
            row(-10),
            row(-3),
            row(-999),
            row(10),
            row(11),
            row(200),
        ) { number ->
            val exception =
                shouldThrowExactly<IllegalArgumentException> {
                    CarAction.generate(number)
                }
            exception.message shouldBe "생성되는 숫자는 0에서 9 사이의 값이어야 합니다."
        }
    }
})
