package study.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import racing.domain.car.Car

class CarTest {
    // 유효성 검증
    @ParameterizedTest
    @MethodSource("validateCarNameTest")
    fun `조건에 맞지 않는 차량 이름일 때, 검증 로직을 실행한다면, 에러가 발생한다`(carName: String, expected: Exception) {
        // given : 조건에 맞지 않는 차량을 생성한다.
        val car = Car(carName)

        // when : 검증 로직을 실행한다.
        val actual = runCatching { car.validate() }.exceptionOrNull()

        // then : 에러가 발생한다.
        assertThat(actual).isInstanceOf(expected::class.java)
    }

    @Test
    fun `자동차의 position값이 1 일때 ,move()가 호출되면, 차량의 position이 1 증가한다`() {
        // given : 자동차 객체 생성한다.
        val car = Car(name = "edy", position = 1)

        // when : move()를 호출한다.
        car.move()

        // then : 차의 position값은 2가 된다.
        assertThat(car.position).isEqualTo(2)
    }

    companion object {
        @JvmStatic
        fun validateCarNameTest() = listOf(
            arrayOf("lightSpeed", IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")),
            arrayOf("  ", IllegalArgumentException("자동차 이름이 공백입니다."))
        )
    }
}
