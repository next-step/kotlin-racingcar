package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    "condition이 4 이상이면 자동차가 전진한다" {
        listOf(
            row(4, 1),
            row(5, 1),
            row(6, 1),
            row(7, 1),
        ).forAll { (condition, expected) ->
            // given
            val car = Car()

            // when
            val actual = car.moveOrNot(condition)

            // then
            actual.position shouldBe expected
        }
    }

    "condition이 4 미만이면 자동차가 전진하지 않는다." {
        listOf(
            row(0, 0),
            row(1, 0),
            row(2, 0),
            row(3, 0),
        ).forAll { (condition, expected) ->
            // given
            val car = Car()

            // when
            val actual = car.moveOrNot(condition)

            // then
            actual.position shouldBe expected
        }
    }
})
