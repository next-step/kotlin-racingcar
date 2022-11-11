package game.racingcar

import game.racingcar.domain.RacingCar
import game.racingcar.move.AlwaysMoveStrategy
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class RacingCarTest {
    @Test
    fun `자동차가 move 메서드를 호출하면 1만큼 앞으로 전진한다`() {
        // given
        val racingCar = RacingCar(moveStrategy = AlwaysMoveStrategy(), name = "haris")
        val preLocation = 0
        // when
        racingCar.move()
        // then
        assertThat(racingCar.location).isEqualTo(preLocation + 1)
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 IllegalArgumentException이 발생한다`() {
        // when & then
        assertThatThrownBy { RacingCar("harris", AlwaysMoveStrategy()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름의 길이는 5자를 초과할 수 없습니다. 입력 값 : harris")
    }

    @Test
    fun `이름이 빈 문자열로 생성되면 IllegalArgumentException이 발생한다`() {
        // when & then
        assertThatThrownBy { RacingCar(name = "") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자열일 수 없습니다.")
    }

    @Test
    fun `이름이 blank 문자열로 생성되면 IllegalArgumentException이 발생한다`() {
        // when & then
        assertThatThrownBy { RacingCar(name = " ") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 빈 문자열일 수 없습니다.")
    }
}
