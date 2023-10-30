package racing.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import racing.fixture.CarFixture

class RacingCarTest : StringSpec({

    "사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다" {
        val actual1 = RacingCar()
            .racing(ArrayDeque(listOf("1")), 1)
            .roundHistories
        actual1[0].result shouldHaveSize 1
        actual1 shouldHaveSize 1

        val actual2 = RacingCar()
            .racing(ArrayDeque(listOf("1", "2", "3")), 5)
            .roundHistories
        actual2[0].result shouldHaveSize 3
        actual2[2].result shouldHaveSize 3
        actual2 shouldHaveSize 5

        val actual3 = RacingCar()
            .racing(CarFixture.carFixtureOfBeforeStart, 17)
            .roundHistories
        val participateCount = CarFixture.carFixtureOfBeforeStart.size
        actual3[0].result shouldHaveSize participateCount
        actual3[4].result shouldHaveSize participateCount
        actual3[16].result shouldHaveSize participateCount
        actual3 shouldHaveSize 17
    }
})
