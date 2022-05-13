package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class CarTests {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `randomNum 이 4보다 작으면 이동하지 않는다`(randomNum: Int) {
        val car = Car(0)
        val position = car.position
        car.moveForwardDependingOption(randomNum)
        assertThat(car.position).isEqualTo(position)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 7, 8, 9])
    fun `randomNum 이 4이상이면 1칸 이동한다`(randomNum: Int) {
        val car = Car(0)
        val position = car.position
        car.moveForwardDependingOption(randomNum)
        assertThat(car.position).isEqualTo(position + 1)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "0, 1",
            "0, 4",
            "3, 2"
        ]
    )
    fun `Car 객체를 deepCopy() 할 경우, id와 Position 값이 같고, 서로 다른 객체여야 한다`(id: Int, position: Int) {
        val car = Car(id)
        // position 값을 할당할 수 없으므로, 이동할 수 있는
        repeat(position) { car.moveForwardDependingOption(CAN_MOVE_RANDOM_NUM) }

        val afterCar = car.deepCopy()

        assertAll(
            {
                // 객체의 값이 같은지 확인
                assertThat(afterCar).isEqualTo(car)
                // 객체의 참조주소까지 같은지 확인
                assert(afterCar !== car)
            }
        )
    }

    companion object {
        const val CAN_MOVE_RANDOM_NUM = 10
    }
}
