package racing.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize
import racing.fixture.CarFixture

class RacingHistoryTest : StringSpec({

    "자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다" {
        val racingHist = RacingHistory(
            ArrayDeque(
                listOf(
                    RoundHistory(CarFixture.carFixtureStep1),
                    RoundHistory(CarFixture.carFixtureStep2),
                    RoundHistory(CarFixture.carFixtureOfAfterFinish)
                )
            )
        )
        val actual = racingHist.winner()
        actual shouldHaveSize 1
        actual shouldContain Car("빨간토마토", 10)
    }

    "우승자는 한명 이상일 수 있다" {
        val racingHist = RacingHistory(
            ArrayDeque(
                listOf(
                    RoundHistory(
                        ArrayDeque(
                            listOf(
                                Car("honux", 5),
                                Car("pobi", 5),
                                Car("crong", 5),
                            )
                        )
                    )
                )
            )
        )
        val actual = racingHist.winner()
        actual shouldHaveSize 3
        actual shouldContain Car("honux", 5)
        actual shouldContain Car("pobi", 5)
        actual shouldContain Car("crong", 5)
    }
})
