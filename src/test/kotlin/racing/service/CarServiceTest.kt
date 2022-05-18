package racing.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.domain.Car
import racing.domain.MockCarSameMovingStepper
import racing.domain.MockFirstCarMoreMovingStepper

internal class CarServiceTest {

    @Test
    fun `주어진 라운드만큼 자동차를 진행시킨다`() {
        val round = 3
        val users = listOf("eunseok", "subway", "hi")
        val cars = users.map { Car(it) }.toList()

        val carService = CarService(MockFirstCarMoreMovingStepper())

        val result = carService.moveCars(cars, round)
        val roundResultViews = result.roundResultViews

        assertAll(
            "CarServiceTest",
            { assertThat(roundResultViews.size).isEqualTo(3) },
            { assertThat(roundResultViews[0].round).isEqualTo(1) },
            { assertThat(roundResultViews[1].round).isEqualTo(2) },
            { assertThat(roundResultViews[2].round).isEqualTo(3) },
        )
    }

    @Test
    fun `유일한 우승자가 나올 수 있다`() {
        val round = 3
        val users = listOf("eunseok", "subway", "hi")
        val cars = users.map { Car(it) }.toList()

        val carService = CarService(MockFirstCarMoreMovingStepper())

        val result = carService.moveCars(cars, round)

        assertAll(
            "CarServiceTest",
            { assertThat(result.winners.size).isEqualTo(1) },
            { assertThat(result.winners[0]).isEqualTo("eunseok") },
        )
    }

    @Test
    fun `우승자는 여러명이 나올 수 있다`() {
        val round = 3
        val users = listOf("eunseok", "subway", "hi")
        val cars = users.map { Car(it) }.toList()

        val carService = CarService(MockCarSameMovingStepper())

        val result = carService.moveCars(cars, round)

        assertAll(
            "CarServiceTest",
            { assertThat(result.winners.size).isEqualTo(3) },
            { assertThat(result.winners[0]).isEqualTo("eunseok") },
            { assertThat(result.winners[1]).isEqualTo("subway") },
            { assertThat(result.winners[2]).isEqualTo("hi") },
        )
    }
}
