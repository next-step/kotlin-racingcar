package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car()
    }

    @DisplayName("Car 생성 테스트")
    @Test
    fun `Car 생성 테스트`() {
        assertThat(car).isEqualTo(Car())
    }

    @DisplayName("Car 이동 테스트")
    @Test
    fun `Car 이동 테스트`() {
        car.move(5)
        assertThat(car).isEqualTo(Car(Position(1)))
    }

    @DisplayName("Car 이동 실패 테스트")
    @Test
    fun `Car 이동 실패 테스트`() {
        car.move(3)
        assertThat(car).isEqualTo(Car())
    }
}
