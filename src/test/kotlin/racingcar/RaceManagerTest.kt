package racingcar

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarFactory
import racingcar.domain.RaceManager
import racingcar.fake.FakeRaceConditionChecker

class RaceManagerTest {
    @Test
    fun `자동차 경주 우승자 이름을 얻을 수 있다`() {
        val cars = CarFactory.generateCars(listOf("pobi", "crong", "honux"))
        val raceManager = RaceManager(moveCount = 5, cars = cars)

        val raceResult = raceManager.startRacing(FakeRaceConditionChecker(5))

        raceResult.findRacingChampions() shouldBe listOf("pobi", "crong", "honux")
    }

    @Test
    fun `자동차 경주에서 전진하는 조건인 경우 자동차는 전진할 수 있다`() {
        val cars = CarFactory.generateCars(listOf("pobi", "crong", "honux"))
        val testChecker = FakeRaceConditionChecker(5)
        val raceManager = RaceManager(5, cars)

        val result = raceManager.startRacing(testChecker)
        result.raceHistories.last().cars.forEach {
            assertThat(it.position == 5)
        }
    }

    @Test
    fun `자동차 경주에서 정지하는 조건인 경우 자동차는 전진하지 않는다`() {
        val cars = CarFactory.generateCars(listOf("pobi", "crong", "honux"))
        val testChecker = FakeRaceConditionChecker(0)
        val raceManager = RaceManager(5, cars)

        val result = raceManager.startRacing(testChecker)
        result.raceHistories.last().cars.forEach {
            assertThat(it.position == 0)
        }
    }
}
