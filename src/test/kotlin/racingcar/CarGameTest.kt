package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row

class CarGameTest : StringSpec({
    "게임 진행을 위해 입력받는 숫자들이 음수라면 게임이 생성되지 않고 예외를 반환한다." {
        forAll(
            row(0, 3),
            row(-1, 4),
            row(2, 0),
            row(2, -1),
            row(-1, -1),
        ) { carCount, repeatCount ->
            shouldThrow<IllegalArgumentException> {
                CarGame(carCount, repeatCount)
            }
        }
    }
})
