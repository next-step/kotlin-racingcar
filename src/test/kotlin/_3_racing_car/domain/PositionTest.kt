package _3_racing_car.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

internal class PositionTest : ExpectSpec() {
    init {
        context("create") {
            expect("포지션 값은 0이상이어야 한다.") {
                shouldThrow<IllegalArgumentException> { Position(-1) }
            }
        }

        context("forward") {
            expect("포지션 값이 증가한다.") {
                forAll(
                    row(1, 1, 2)
                ) { init, plus, expected ->

                    val position = Position(value = init)

                    position.forward(plus)

                    position.value shouldBe expected
                }
            }
        }
    }
}
