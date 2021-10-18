package racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@Suppress("NonAsciiCharacters")
class CarsTest {

    @Test
    fun `비어있는 Cars는 생성될 수 없다`() {
        assertThatThrownBy {
            Cars(emptyList())
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Car는 하나 이상 존재해야합니다")
    }

    @Test
    fun `차들을 이동시키면 이동에 성공한 차는 이동하고, 실패한 차는 이동하지 않는다`() {
        val cars = Cars(listOf(Car(goEngine), Car(stopEngine)))

        cars.go()

        assertAll(
            { assertThat(cars.cars[0].position).isEqualTo(Position(1)) },
            { assertThat(cars.cars[1].position).isEqualTo(Position(0)) }
        )
    }
}
