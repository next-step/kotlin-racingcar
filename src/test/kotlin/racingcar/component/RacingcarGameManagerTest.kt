package racingcar.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import racingcar.model.Car

class RacingcarGameManagerTest : FunSpec({
    val cars = Cars()

    test("우승자가 다수일 경우 정확한 우승자 수를 반환하는지 테스트") {
        val winners = listOf(
            Car("dummy1"),
            Car("dummy2")
        )

        val result = cars.getWinners(winners)

        result.size shouldBe 2
    }
})
