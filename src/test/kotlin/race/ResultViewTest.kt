package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
class ResultViewTest {

    @Test
    fun visualizeLocation() {
        val car = SimpleCar("test")

        assertThat(ResultView().visualizeLocation(car)).isEqualTo("")

        repeat(3) { car.move(4) }
        assertThat(ResultView().visualizeLocation(car)).isEqualTo("---")
    }
}
