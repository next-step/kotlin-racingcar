package racingcar.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    "condition에 따라서 자동차가 전진 혹은 전진하지 않는다." {
        listOf(
            row(3, 0),
            row(4, 1),
        ).forAll { (condition, expected) ->
            // given
            val car = Car("k5")

            // when
            val actual = car.moveOrNot(condition)

            // then
            actual.position.value shouldBe expected
        }
    }
})
