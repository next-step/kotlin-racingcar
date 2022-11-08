package racingcar

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingCarGameSnapShotsTest : StringSpec({

    "Get positions of all cars at n th trial "() {

        val car1 = Car(1)
        car1.move(1)
        car1.move(2)

        val car2 = Car(2)
        car2.move(9)
        car2.move(8)

        val sut = RacingCarGameSnapShots(listOf(car1, car2))

        assertSoftly(sut) {
            it.getPositions(1) shouldBe (listOf(1, 9))
            it.getPositions(2) shouldBe (listOf(3, 17))
        }
    }

    "cannot get position of which bigger than number of trial"() {

        val car1 = Car(1)
        car1.move(1)

        val sut = RacingCarGameSnapShots(listOf(car1))

        val ex = shouldThrow<IllegalArgumentException> {
            sut.getPositions(2)
        }

        ex.message.shouldBe("Cannot get position, bigger than number of trial 2")
    }
})
