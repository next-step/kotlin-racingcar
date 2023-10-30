package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.data.RacingCar
import step3.domain.MoveCourse

class MoveCourseTest {
    @Test
    fun `움직이는데 성공하면 RacingCar 카운트가 늘어난다`() {
        val car = RacingCar(1)
        MoveCourse.moveCourse(car, true)
        assertThat(car.moveCount).isEqualTo(2)
    }

    @Test
    fun `움직이는데 실패하면 RacingCar 카운트가 그대로다`() {
        val car = RacingCar(2)
        MoveCourse.moveCourse(car, false)
        assertThat(car.moveCount).isEqualTo(2)
    }
}
