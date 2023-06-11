package racingcar.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import racingcar.domain.Car.Companion.MOVE_THRESHOLD
import racingcar.domain.Car.Companion.START_POSITION
import racingcar.domain.Car.Companion.STEP
import racingcar.util.NumberGenerator.Companion.MAX_GENERATED_NUMBER
import racingcar.util.NumberGenerator.Companion.MIN_GENERATED_NUMBER
import racingcar.util.OrderNumberGenerator

class CarTest : BehaviorSpec({
    given("movable 메소드") {
        forAll(
            table(
                headers("number", "expected"),
                *(MIN_GENERATED_NUMBER until MOVE_THRESHOLD).map { row(it, false) }.toTypedArray(),
                *(MOVE_THRESHOLD..MAX_GENERATED_NUMBER).map { row(it, true) }.toTypedArray()
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
            then("position을 ${STEP}만큼 증가시킨다") {
                val car = Car(OrderNumberGenerator(MOVE_THRESHOLD))
                car.move()
                car.getPosition() shouldBe START_POSITION + STEP
            }
        }

        `when`("movable이 false를 반환하면") {
            then("position을 증가시키지 않는다") {
                val car = Car(OrderNumberGenerator(MOVE_THRESHOLD - 1))
                car.move()
                car.getPosition() shouldBe START_POSITION
            }
        }
    }
})
