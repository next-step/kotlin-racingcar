package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class CarTest : ShouldSpec({
    val sut = Car("pobi")

    context("자동차는") {
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

        should("이름이 5글자 이상일 경우 예외가 발생한다..") {
            forAll(
                row("aaaaaa"),
                row("aaaaab"),
                row("aaaaac"),
            ) { expected ->
                shouldThrow<IllegalArgumentException> {
                    Car(expected)
                }.message shouldBe "자동차 이름은 5자 이하만 가능합니다."
            }
        }
    }

})
