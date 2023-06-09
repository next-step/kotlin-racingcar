package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceGameTest {
    @Test
    fun `입력된 자동차 수와 RaceResult의 자동차 수가 동일해야 한다`() {
        val raceStartInformation = RaceStartInformation(nameOfCars = List(3) { it.toString() }, numberOfAttempts = 5)

        CarRaceGame(RandomUtilImpl).runCarRace(raceStartInformation)
            .turns
            .map {
                it.cars
                    .size
            }.forEach {
                assertThat(it).isEqualTo(raceStartInformation.nameOfCars.size)
            }
    }

    @Test
    fun `RaceResult 내 turns 길이는 입력된 시도 횟수 + 1 이어야 한다`() {
        val raceStartInformation = RaceStartInformation(nameOfCars = List(3) { it.toString() }, numberOfAttempts = 5)

        CarRaceGame(RandomUtilImpl).runCarRace(raceStartInformation)
            .turns
            .size
            .let {
                assertThat(it).isEqualTo(raceStartInformation.numberOfAttempts + 1)
            }
    }

    @Test
    fun `RaceResult 내 turns의 첫번째 아이템은 InitialTurn, 그 다음 부터는 Turn이어야 한다`() {
        val raceStartInformation = RaceStartInformation(nameOfCars = List(3) { it.toString() }, numberOfAttempts = 5)

        CarRaceGame(RandomUtilImpl).runCarRace(raceStartInformation)
            .turns
            .forEachIndexed { index, turn ->
                if (index == 0) assertThat(turn is InitialTurn).isTrue()
                else assertThat(turn is Turn).isTrue()
            }
    }

    @Test
    fun `무작위 값이 4 미만일 경우 차량은 전진하지 못한다`() {
        val number3Generator = object : RandomUtil {
            override fun generateRandomSingleDigit() = 3
        }

        val raceStartInformation = RaceStartInformation(nameOfCars = listOf("1"), numberOfAttempts = 1)

        val (positionBeforeTurn, positionAfterTurn) = CarRaceGame(number3Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.cars
                    .first()
                    .position
            }.let {
                it.first() to it.last()
            }

        assertThat(positionAfterTurn - positionBeforeTurn).isEqualTo(0)
    }

    @Test
    fun `무작위 값이 4 이상일 경우 차량을 전진한다`() {
        val number4Generator = object : RandomUtil {
            override fun generateRandomSingleDigit() = 4
        }

        val raceStartInformation = RaceStartInformation(nameOfCars = listOf("1"), numberOfAttempts = 1)

        val (positionBeforeTurn, positionAfterTurn) = CarRaceGame(number4Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.cars
                    .first()
                    .position
            }.let {
                it.first() to it.last()
            }

        assertThat(positionAfterTurn - positionBeforeTurn).isEqualTo(1)
    }
}
