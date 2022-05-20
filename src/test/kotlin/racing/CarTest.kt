package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.domain.Car
import racing.domain.vo.CarMoveResult
import racing.domain.vo.Name
import racing.domain.vo.Position

class CarTest {
    private lateinit var car: Car
    private lateinit var name: Name

    @BeforeEach
    fun setUp() {
        name = Name("Test")
        car = Car(name, Position())
    }

    @Test
    fun `자동차 전진 테스트`() {
        assertThat(car.move { true }).isEqualTo(CarMoveResult(name, Position(1)))
    }

    @Test
    fun `자동차 정지 테스트`() {
        assertThat(car.move { false }).isEqualTo(CarMoveResult(name, Position(0)))
    }
}
