package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `Racing car 생성자 파라미터 숫자만큼 Car의 인스턴스를 생성한다`() {
        val carNames = listOf("a", "b", "c")
        val racingCar = RacingCar(carNames)
        assertThat(racingCar.cars.size).isEqualTo(carNames.size)
    }

    @Test
    fun `moveForward`() {
        val position = Car("a").moveForward()
        assertThat(position in 0..1).isTrue()
    }

    // private 메서드를 테스트하는 방법을 검색해서 java의 reflection을 사용했는데...
    // 배보다 배꼽이 커진느낌을 지울 수 없습니다. 더 좋은 방법이 있는지 궁금합니다!
    @Test
    fun `can move false`() {
        val car = Car("a")
        val canMoveMethod = car.javaClass.getDeclaredMethod("canMove", Int::class.java)
        canMoveMethod.trySetAccessible()
        assertThat(canMoveMethod.canAccess(car)).isTrue()
        val actual = canMoveMethod.invoke(car, 3) as Boolean
        assertThat(actual).isFalse()
    }

    @Test
    fun `can move true`() {
        val car = Car("a")
        val canMoveMethod = car.javaClass.getDeclaredMethod("canMove", Int::class.java)
        canMoveMethod.trySetAccessible()
        assertThat(canMoveMethod.canAccess(car)).isTrue()
        val actual = canMoveMethod.invoke(car, 4) as Boolean
        assertThat(actual).isTrue()
    }
}
