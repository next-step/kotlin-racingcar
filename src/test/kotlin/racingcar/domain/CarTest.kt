package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import racingcar.util.NumberGenerator
import racingcar.util.OrderNumberGenerator
import racingcar.util.RandomNumberGenerator

class CarTest : BehaviorSpec({
    given("Car생성시") {
        `when`("이름이 ${Car.MAX_NAME_LENGTH}자를 초과하면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> {
                    Car("a".repeat(Car.MAX_NAME_LENGTH + 1), RandomNumberGenerator)
                }
            }
        }
        `when`("이름이 비어있으면") {
            then("예외가 던져진다") {
                shouldThrow<IllegalArgumentException> {
                    Car(" ", RandomNumberGenerator)
                }
            }
        }
        for (size in Car.MIN_NAME_LENGTH..Car.MAX_NAME_LENGTH) {
            `when`("이름이 ${size}글자면") {
                then("Car가 생성된다") {
                    shouldNotThrow<Throwable> {
                        Car("a".repeat(size), RandomNumberGenerator)
                    }
                }
            }
        }
    }

    given("movable 메소드") {
        forAll(
            table(
                headers("number", "expected"),
                *(NumberGenerator.MIN_GENERATED_NUMBER until Car.MOVE_THRESHOLD).map { row(it, false) }.toTypedArray(),
                *(Car.MOVE_THRESHOLD..NumberGenerator.MAX_GENERATED_NUMBER).map { row(it, true) }.toTypedArray(),
            ),
        ) { number, expected ->
            `when`("${number}가 나오면") {
                then("${expected}를 반환한다") {
                    val car = Car(number.toString(), OrderNumberGenerator(number))
                    car.movable() shouldBe expected
                }
            }
        }
    }

    given("move 메소드") {
        `when`("movable이 true를 반환하면") {
            then("position을 ${Car.STEP}만큼 증가시킨다") {
                val car = Car(TEST_CAR_NAME, OrderNumberGenerator(Car.MOVE_THRESHOLD))
                car.move()
                car.position shouldBe Car.START_POSITION + Car.STEP
            }
        }

        `when`("movable이 false를 반환하면") {
            then("position을 증가시키지 않는다") {
                val car = Car(TEST_CAR_NAME, OrderNumberGenerator(Car.MOVE_THRESHOLD - 1))
                car.move()
                car.position shouldBe Car.START_POSITION
            }
        }
    }
}) {
    companion object {
        private const val TEST_CAR_NAME = "car"
    }
}
