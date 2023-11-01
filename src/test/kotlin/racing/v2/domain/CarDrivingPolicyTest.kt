package racing.v2.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class `자동차 전진 정책 테스트` : StringSpec({
    "임의의 수가 4 이상일 경우 자동차는 전진할 수 있다." {
        forAll(
            row(4),
            row(5),
            row(6),
            row(7),
            row(8),
            row(9),
        ) { number: Int ->
            CarDrivingPolicy.canForward(number) shouldBe true
        }
    }

    "임의의 수가 3 이하일 경우 자동차는 전진할 수 없다." {
        forAll(
            row(1),
            row(2),
            row(3),
        ) { number: Int ->
            CarDrivingPolicy.canForward(number) shouldBe false
        }
    }
})
