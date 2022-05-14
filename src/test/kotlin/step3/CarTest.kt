package step3

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.assertj.core.api.Assertions
import org.assertj.core.util.Strings
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ExtendWith(MockKExtension::class)
class CarTest {

    @MockK
    lateinit var movingStrategy: MovingStrategy

    @ParameterizedTest
    @ValueSource(strings = ["jay","evan","kevin"])
    fun `1) 이동 성공 + 자동차 이름 저장`(input: String) {
        val car = Car.makeCar(input)
        every { movingStrategy.movable() } returns true
        car.move(movingStrategy)
        Assertions.assertThat(car.getPosition()).isEqualTo(1)
        Assertions.assertThat(car.getCarName()).isEqualTo(input)
    }


    @ParameterizedTest
    @ValueSource(strings = ["jay","evan","kevin"])
    fun `2) 이동 실패 + 자동차 이름 저장`(input: String) {
        val car = Car.makeCar(input)
        every { movingStrategy.movable() } returns false
        car.move(movingStrategy)
        Assertions.assertThat(car.getPosition()).isEqualTo(0)
        Assertions.assertThat(car.getCarName()).isEqualTo(input)
    }
}
