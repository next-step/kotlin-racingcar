package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.mock

class RaceGameTest {
    @Test
    fun `입력된 자동차 수와 RaceResult의 자동차 수가 동일해야 한다`() {
        val raceStartInformation = RaceStartInformation(numberOfCars = 3, numberOfAttempts = 5)

        CarRaceGame(RandomUtil).runCarRace(raceStartInformation)
            .turns
            .map {
                it.carPositions
                    .size
            }.forEach {
                assertThat(it).isEqualTo(raceStartInformation.numberOfCars)
            }
    }

    @Test
    fun `RaceResult 내 turns 길이는 입력된 시도 횟수 + 1 이어야 한다`() {
        val raceStartInformation = RaceStartInformation(numberOfCars = 3, numberOfAttempts = 5)

        CarRaceGame(RandomUtil).runCarRace(raceStartInformation)
            .turns
            .size
            .let {
                assertThat(it).isEqualTo(raceStartInformation.numberOfAttempts + 1)
            }
    }

    @Test
    fun `RaceResult 내 turns의 첫번째 아이템은 InitialTurn, 그 다음 부터는 Turn이어야 한다`() {
        val raceStartInformation = RaceStartInformation(numberOfCars = 3, numberOfAttempts = 5)

        CarRaceGame(RandomUtil).runCarRace(raceStartInformation)
            .turns
            .forEachIndexed { index, turn ->
                if (index == 0) assertThat(turn is InitialTurn).isTrue()
                else assertThat(turn is Turn).isTrue()
            }
    }

    @Test
    fun `무작위 값이 4 미만일 경우 차량은 전진하지 못한다`() {
        val number3Generator = mock(RandomUtil::class.java).apply {
            Mockito.`when`(generateRandomSingleDigit()).thenReturn(3)
        }

        val raceStartInformation = RaceStartInformation(numberOfCars = 1, numberOfAttempts = 1)

        val (positionBeforeTurn, positionAfterTurn) = CarRaceGame(number3Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.carPositions
                    .first()
                    .position
            }.let {
                it.first() to it.last()
            }

        assertThat(positionAfterTurn - positionBeforeTurn).isEqualTo(0)
    }

    @Test
    fun `무작위 값이 4 이상일 경우 차량을 전진한다`() {
        val number4Generator = mock(RandomUtil::class.java).apply {
            Mockito.`when`(generateRandomSingleDigit()).thenReturn(4)
        }

        val raceStartInformation = RaceStartInformation(numberOfCars = 1, numberOfAttempts = 1)

        val (positionBeforeTurn, positionAfterTurn) = CarRaceGame(number4Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.carPositions
                    .first()
                    .position
            }.let {
                it.first() to it.last()
            }

        assertThat(positionAfterTurn - positionBeforeTurn).isEqualTo(1)
    }
}
