package race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `레이스당 자동차가 움직였는지 여부 판단`() {
        // Arrange
        val car = Car()

        // Act
        car.move(true)
        car.move(false)

        // Assert
        assertThat(car.movedDistance[0]).isTrue
        assertThat(car.movedDistance[1]).isFalse
    }
}
