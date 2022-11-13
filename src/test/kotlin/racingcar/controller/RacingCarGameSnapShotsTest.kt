package racingcar.controller

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingCarGameSnapShotsTest : StringSpec({

    "Get positions of all cars at n th trial " {

        val sut = RacingCarGameSnapShots(
            RacingCarGameSnapShot(listOf(1, 0)),
            RacingCarGameSnapShot(listOf(2, 1))
        )
        assertSoftly(sut) {
            it.getPositions(1) shouldBe (listOf(1, 0))
            it.getPositions(2) shouldBe (listOf(2, 1))
        }
    }

    "cannot get position of which bigger than number of trial" {

        val sut = RacingCarGameSnapShots(
            RacingCarGameSnapShot(listOf(1))
        )

        val ex = shouldThrow<IllegalArgumentException> {
            sut.getPositions(2)
        }

        ex.message.shouldBe("Cannot get position, bigger than number of trial 2")
    }
})
