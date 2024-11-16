package racingcar.domain.vo

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe

class CarPositionTest : StringSpec({
    "위치는 음수가 될 수 없다." {
        forAll(
            row(-1),
            row(-2),
            row(-3),
        ) { position ->
            shouldThrowExactly<IllegalArgumentException> {
                CarPosition(position)
            }
        }
    }

    "전진 시 위치가 1 증가한다." {
        forAll(
            table(
                headers("beforeValue", "afterValue"),
                row(0, 1),
                row(1, 2),
                row(29, 30),
                row(100, 101),
            ),
        ) { beforeValue, afterValue ->
            val carPosition = CarPosition(beforeValue)
            carPosition.advance().value shouldBe afterValue
        }
    }
})
