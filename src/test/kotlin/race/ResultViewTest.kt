package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
class ResultViewTest {

    @Test
    fun `location 시각화 테스트`() {
        val car = SimpleCar("test")

        assertThat(ResultView().visualizeLocation(car)).isEqualTo("")

        repeat(3) { car.move(SimpleCar.MOVE_THRESHOLD) }
        assertThat(ResultView().visualizeLocation(car)).isEqualTo("---")
    }
}
