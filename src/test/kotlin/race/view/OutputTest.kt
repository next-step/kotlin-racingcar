package race.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import race.domain.SimpleCar

class OutputTest {
    @Test
    fun `location 시각화 테스트`() {
        val car = SimpleCar("test")

        assertThat(Output().visualizeLocation(car)).isEqualTo("")

        repeat(3) { car.move(SimpleCar.MOVE_THRESHOLD) }
        assertThat(Output().visualizeLocation(car)).isEqualTo("---")
    }
}
