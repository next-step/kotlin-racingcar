package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.domain.Car
import race.domain.CarRaceGame
import race.domain.DigitGenerator
import race.domain.InitialTurn
import race.domain.RaceResult
import race.domain.RaceStartInformation
import race.domain.RandomSingleDigitGenerator
import race.domain.Turn

class RaceGameTest {
    @Test
    fun `입력된 자동차 수와 RaceResult의 자동차 수가 동일해야 한다`() {
        val raceStartInformation = RaceStartInformation(nameOfCars = List(3) { it.toString() }, numberOfAttempts = 5)

        CarRaceGame(RandomSingleDigitGenerator).runCarRace(raceStartInformation)
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

        CarRaceGame(RandomSingleDigitGenerator).runCarRace(raceStartInformation)
            .turns
            .size
            .let {
                assertThat(it).isEqualTo(raceStartInformation.numberOfAttempts + 1)
            }
    }

    @Test
    fun `RaceResult 내 turns의 첫번째 아이템은 InitialTurn, 그 다음 부터는 Turn이어야 한다`() {
        val raceStartInformation = RaceStartInformation(nameOfCars = List(3) { it.toString() }, numberOfAttempts = 5)

        CarRaceGame(RandomSingleDigitGenerator).runCarRace(raceStartInformation)
            .turns
            .forEachIndexed { index, turn ->
                if (index == 0) assertThat(turn is InitialTurn).isTrue()
                else assertThat(turn is Turn).isTrue()
            }
    }

    @Test
    fun `무작위 값이 4 미만일 경우 차량은 전진하지 못한다`() {
        val number3Generator = object : DigitGenerator {
            override operator fun invoke() = 3
        }

        val raceStartInformation = RaceStartInformation(nameOfCars = listOf("1"), numberOfAttempts = 1)

        val (before, after) = CarRaceGame(number3Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.cars
                    .first()
            }.let {
                it.first() to it.last()
            }

        assertThat(before.isDraw(after)).isTrue()
    }

    @Test
    fun `무작위 값이 4 이상일 경우 차량을 전진한다`() {
        val number4Generator = object : DigitGenerator {
            override operator fun invoke() = 4
        }

        val raceStartInformation = RaceStartInformation(nameOfCars = listOf("1"), numberOfAttempts = 1)
        val carAtPosition1 = Car(1, "")

        val carAfterRace = CarRaceGame(number4Generator).runCarRace(raceStartInformation)
            .turns
            .map {
                it.cars
                    .first()
            }.last()

        assertThat(carAfterRace.isDraw(carAtPosition1)).isTrue()
    }

    @Test
    fun `RaceResult의 frontrunners() 함수는 맨 앞의 차량을 반환한다`() {
        val frontrunner = Car(position = 3, name = "")
        val car1 = Car(position = 0, name = "")
        val car2 = Car(position = 1, name = "")
        val cars = listOf(frontrunner, car1, car2)

        assertThat(RaceResult(listOf(Turn(cars))).frontrunners()).isEqualTo(setOf(frontrunner))
    }

    @Test
    fun `선두 차량이 여러대일 경우 RaceResult의 frontrunners() 함수는 선두 차량들을 모두 반환한다`() {
        val frontrunner1 = Car(position = 3, name = "")
        val frontrunner2 = Car(position = 3, name = "")
        val frontrunner3 = Car(position = 3, name = "")
        val car1 = Car(position = 0, name = "")
        val cars = listOf(frontrunner1, car1, frontrunner2, frontrunner3)

        assertThat(RaceResult(listOf(Turn(cars))).frontrunners()).isEqualTo(setOf(frontrunner2, frontrunner1))
    }

    @Test
    fun `두 차량의 position이 같으면 isDraw()는 true를 리턴한다`() {
        val car1 = Car(position = 1, name = "")
        val car2 = Car(position = 1, name = "")
        assertThat(car1.isDraw(car2)).isTrue()
    }

    @Test
    fun `두 차량의 position이 다르면 isDraw()는 false를 리턴한다`() {
        val looser = Car(position = 0, name = "")
        val winner = Car(position = 1, name = "")
        assertThat(looser.isDraw(winner)).isFalse()
    }

    @Test
    fun `Car_winner()는 두 차량 중 position이 더 큰 차량을 리턴한다`() {
        val looser = Car(position = 0, name = "")
        val winner = Car(position = 1, name = "")
        assertThat(Car.winner(looser, winner)).isEqualTo(winner)
    }
}
