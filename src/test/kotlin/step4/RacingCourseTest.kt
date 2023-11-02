package step4

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step4.domain.CarName
import step4.domain.RacingCar
import step4.domain.RacingCars
import step4.domain.RacingCourse

class RacingCourseTest {
    @Test
    fun `RacingCourse의 MoveStrategy가 항상 성공할 시 tryCount만큼 움직인다`() {
        val racingCourse =
            RacingCourse(
                tryCount = 4,
                racingCars = RacingCars(
                    listOf(
                        RacingCar(CarName(name = "fac"), moveCount = 0),
                        RacingCar(CarName(name = "fac1"), moveCount = 1)
                    )
                )
            )
        racingCourse.moveCars(FixedStrategy(4)) {}
        assertThat(racingCourse.racingCars.carList).isEqualTo(
            listOf(
                RacingCar(CarName(name = "fac"), moveCount = 4),
                RacingCar(CarName(name = "fac1"), moveCount = 5)
            )
        )
    }

    @Test
    fun `RacingCourse의 MoveStrategy가 항상 실패할 시 움직이지 않는다`() {
        val racingCourse =
            RacingCourse(5, RacingCars(listOf(RacingCar(CarName("fac"), 0), RacingCar(CarName("fac1"), 1))))
        racingCourse.moveCars(FixedStrategy(3)) {}
        assertThat(racingCourse.racingCars.carList).isEqualTo(
            listOf(
                RacingCar(CarName(name = "fac"), moveCount = 0),
                RacingCar(CarName(name = "fac1"), moveCount = 1)
            )
        )
    }
}
