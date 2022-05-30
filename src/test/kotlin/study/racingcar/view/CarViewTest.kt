package study.racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.domain.Car

internal class CarViewTest {

    @Test
    fun `car position이 0일 때, car view result`() {
        val car = Car("name", 0)

        val carView = CarView(car)

        assertThat(carView.result).isEqualTo("name : ")
    }

    @Test
    fun `car position이 1일 때, car view result`() {
        val car = Car("name", 1)

        val carView = CarView(car)

        assertThat(carView.result).isEqualTo("name : -")
    }
}
