package racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarTest : StringSpec({
    "move Car then position changed"() {
        val car = Car(1)
        car.move(1)

        car.getPositionAt(1) shouldBe 1
    }

    "cannot get position if trial number is zero or negative "() {
        val car = Car(1)
        car.move(1)

        shouldThrow<IllegalArgumentException> {
            car.getPositionAt(0)
        }
    }

    "cannot get position if trial number is bigger than total trials"() {
        val car = Car(1)
        car.move(1)

        shouldThrow<IllegalArgumentException> {
            car.getPositionAt(2)
        }
    }

    "after moving Car, can get position at specific trial"() {
        val car = Car(1)
        car.move(1)
        car.move(3)
        car.move(4)

        assertSoftly(car) {
            it.getPositionAt(1) shouldBe 1
            it.getPositionAt(2) shouldBe 4
            it.getPositionAt(3) shouldBe 8
        }
    }
    "after moving Car, can get current position"() {
        val car = Car(1)
        car.move(1)
        car.move(3)
        car.move(4)

        car.getCurrentPosition() shouldBe 8
    }
})
