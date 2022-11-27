package racing.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarsTest : StringSpec({

    "경주에 참가하는 자동차는 2대 이상이어야 한다" {
        listOf(
            "",
            "자동차A"
        ).forEach { names ->
            run {
                shouldThrow<IllegalArgumentException> {
                    Cars.create(names)
                }
            }
        }
    }

    "전진하는 조건에 따라 자동차들의 위치 값이 변경된다." {
        listOf(
            Movable { true } to listOf(1, 1, 1),
            Movable { false } to listOf(0, 0, 0),
        ).forEach { (movable, expected) ->
            run {
                val cars = Cars.create("자동차A, 자동차B, 자동차C")
                cars.move(movable)
                cars.positions() shouldBe expected
            }
        }
    }
})
