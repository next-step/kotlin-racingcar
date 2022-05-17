package step3.dto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import step3.model.Car

class TrackResultTest : FunSpec({

    test("getWinners") {
        val car1 = Car("car1")
        val car2 = Car("car2")
        val car3 = Car("car3")

        TrackResult(
            listOf(
                MoveResult(car1, 1),
                MoveResult(car2, 2),
                MoveResult(car3, 2),
            )
        ).getWinners() shouldBe listOf(car2, car3)
    }
})
