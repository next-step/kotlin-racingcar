package racing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class CarRacingTest {

    @Test
    fun `주어진 자동차 이름에 해당하는 자동차를 생성한다`() {
        // given
        val namesOfCars = listOf("car1", "car2", "car3")

        // when
        val carRacing = CarRacing(
            namesOfCars = namesOfCars,
            moveStrategy = moveStrategy,
        )

        // then
        assertEquals(namesOfCars.sorted(), carRacing.carInfos.map(CarInfo::name).sorted())
    }

    @Test
    fun `move 함수를 호출하면 내부의 자동차들이 이동한다`() {
        // given
        val carRacing = CarRacing(
            namesOfCars = listOf("car1", "car2", "car3"),
            moveStrategy = moveStrategy,
        )

        // when
        carRacing.move()

        // then
        assertTrue(carRacing.carInfos.all { it.position == MOVE_SIZE })
    }

    @Test
    fun `우승 자동차 목록 반환 테스트`() {
        // given
        val namesOfCars = listOf("car1", "car2", "car3")
        val carRacing = CarRacing(
            namesOfCars = namesOfCars,
            moveStrategy = moveStrategy,
        )
        carRacing.move()

        // when
        val winnerCarInfos = carRacing.winnerCarInfos

        // then
        assertEquals(namesOfCars.sorted(), winnerCarInfos.map(CarInfo::name).sorted())
    }

    companion object {
        const val MOVE_SIZE = 1

        val moveStrategy = MoveStrategy { MOVE_SIZE }
    }
}
