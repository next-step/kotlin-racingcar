package carRacing

import carRacing.testcontroller.TestTrueMovementController
import carRacing.view.CarInfo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarInfoTest {

    @Test
    fun `CarInfo 객체를 생성할 수 있다`() {
        // given
        val name = "a"

        // when
        val carInfo = CarInfo(name, TestTrueMovementController())

        // then
        assertThat(carInfo.name).isEqualTo(name)
    }

    @Test
    fun `CarInfo movementController property 값이 null 이 아닐 경우 movementController property 값을 가져올 수 있다`() {
        val carInfo = CarInfo("a", TestTrueMovementController())

        assertThat(carInfo.movementController::class).isEqualTo(TestTrueMovementController::class)
    }
}
