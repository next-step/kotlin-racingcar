package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import racingcar.util.OrderNumberGenerator

class CarTest : BehaviorSpec({
    given("movable 메소드") {
        forAll(
            table(
                headers("number", "expected"),
                *(0..3).map { row(it, false) }.toTypedArray(),
                *(4..9).map { row(it, true) }.toTypedArray()
            )
        ) { number, expected ->
            `when`("${number}가 나오면") {
                then("${expected}를 반환한다") {
                    val car = Car(OrderNumberGenerator(number))
                    car.movable() shouldBe expected
                }
            }
        }
    }

    given("move 메소드") {
        `when`("movable이 true를 반환하면") {
            then("position을 1 증가시킨다") {
                val car = Car(OrderNumberGenerator(4))
                car.move()
                car.getPosition() shouldBe 2
            }
        }

        `when`("movable이 false를 반환하면") {
            then("position을 증가시키지 않는다") {
                val car = Car(OrderNumberGenerator(3))
                car.move()
                car.getPosition() shouldBe 1
            }
        }
    }
})
