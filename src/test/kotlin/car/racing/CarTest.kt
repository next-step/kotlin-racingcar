package car.racing

import car.racing.domain.Car
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [5, 6, 7, 8, 9])
    fun `Move 테스트`(condition: Int) {
        val car = Car(1)

        val response = car.move(1, condition)

        assertEquals("-", response)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `Stop 테스트`(condition: Int) {
        val car = Car(1)

        val response = car.move(1, condition)

        assertEquals("", response)
    }

    @Test
    fun `5번 움직였을때 -----`() {
        val car = Car(5)
        val condition = 5

        (1..5).forEach { turn ->
            println(turn)
            car.move(turn, condition)
        }

        val moveDistance = car.getMoveDistanceUntilTurn(5)

        assertEquals("-----", moveDistance)
    }

    @Test
    fun `5번 안움직였을때 ''`() {
        val car = Car(5)
        val condition = 0

        (1..5).forEach { turn ->
            println(turn)
            car.move(turn, condition)
        }

        val moveDistance = car.getMoveDistanceUntilTurn(5)

        assertEquals("", moveDistance)
    }

    @Test
    fun `1,3,5 움직였을 때 4번째턴까지의 정보 "--"`() {
        val car = Car(5)

        car.move(1, 5)
        car.move(3, 0)
        car.move(5, 5)

        val moveDistance = car.getMoveDistanceUntilTurn(4)

        assertEquals("--", moveDistance)
    }

    @Test
    fun `1,3,5 움직였을 때 2번째턴까지의 정보 "-"`() {
        val car = Car(5)

        car.move(1, 5)
        car.move(3, 0)
        car.move(5, 5)

        val moveDistance = car.getMoveDistanceUntilTurn(2)

        assertEquals("-", moveDistance)
    }
}
