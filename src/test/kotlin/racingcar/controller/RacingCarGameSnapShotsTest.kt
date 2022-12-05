package racingcar.controller

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class RacingCarGameSnapShotsTest : StringSpec({

    "Get snapshots of all cars at n th trial "() {
        val shot1 = RacingCarGameSnapShot(
            listOf(
                CarSnapShot("mia", 1),
                CarSnapShot("comp", 9)
            )
        )
        val shot2 = RacingCarGameSnapShot(
            listOf(
                CarSnapShot("mia", 3),
                CarSnapShot("comp", 17)
            )
        )

        val sut = RacingCarGameSnapShots(shot1, shot2)
        assertSoftly(sut) {
            it.snapShots[0] shouldBe RacingCarGameSnapShot(listOf(CarSnapShot("mia", 1), CarSnapShot("comp", 9)))
            it.snapShots[1] shouldBe RacingCarGameSnapShot(listOf(CarSnapShot("mia", 3), CarSnapShot("comp", 17)))
        }
    }

    "cannot get snapshot at trial of which bigger than number of trial"() {

        val shot1 = RacingCarGameSnapShot(listOf(CarSnapShot("mia", 2)))

        val sut = RacingCarGameSnapShots(listOf(shot1))
        val ex = shouldThrow<IllegalArgumentException> {
            sut.getCarSnapshots(2)
        }

        ex.message.shouldBe("Cannot get snapshot, bigger than number of trial 2")
    }
})
