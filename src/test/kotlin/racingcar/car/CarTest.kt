package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `자동차 이름이 없는 경우`() {
        // given
        val engine = MockEngine(1)

        // when & then
        Assertions.assertThatThrownBy { Car("", engine) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 필수값입니다.")
    }

    @Test
    fun `차 생성`() {
        // given
        val engine = MockEngine(1)

        // when & then
        Assertions.assertThatCode { Car("abcde", engine) }.doesNotThrowAnyException()
    }

    @Test
    fun `차이름 길이가 임계치를 넘어가는 경우`() {
        // given
        val engine = MockEngine(1)

        // when & then
        Assertions.assertThatThrownBy { Car("abcdef", engine) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("이름 길이는")
            .hasMessageContaining("을 초과할수 없습니다")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `차 움직이지 않을 경우`(givenRpm: Int) {
        // given
        val engine = MockEngine(givenRpm)
        val car = Car("test", engine)

        // when
        car.move()

        // then
        Assertions.assertThat(car.distance).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `차가 움직일 때 테스트`(givenRpm: Int) {
        // given
        val engine = MockEngine(givenRpm)
        val car = Car("test", engine)

        // when
        car.move()

        // then
        Assertions.assertThat(car.distance).isEqualTo(1)
    }
}
