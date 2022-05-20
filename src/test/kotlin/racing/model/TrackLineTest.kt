package racing.model

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TrackLineTest : FunSpec({

    test("move") {
        val alwaysMovingCar = Car("car") { _, _ -> Car.MOVABLE_THRESHOLD }
        val trackLine = TrackLine(alwaysMovingCar)

        trackLine.move()
        trackLine.move()

        trackLine.position shouldBe 2
    }
})
