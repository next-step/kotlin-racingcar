package racingcar.domain

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({
    val sut = Car()

    should("요청 값이 4 이상, 9 이하면 전진한다.") {
        forAll(
            row(4),
            row(5),
            row(6),
            row(7),
            row(8),
            row(9),
        ) { expected ->
            val actual = sut.move(expected)
            sut.position shouldBe 1
            actual.position shouldBe 2
        }
    }
})
