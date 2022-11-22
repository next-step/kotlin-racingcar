package racingcar.domain.input

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacersTest {
    @DisplayName("Racers 생성 테스트")
    @Test
    fun `Racers 생성 테스트`() {
        val racers = Racers("pobi, crong")
        assertThat(racers).isEqualTo(Racers("pobi, crong"))
    }

    @DisplayName("Racers 생성 예외처리 테스트")
    @Test
    fun `Racers 생성 예외처리 테스트`() {
        assertThatThrownBy { Racers("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 1글자 이상이어야 합니다.")
    }

    @DisplayName("쉼표(,) 구분 테스트")
    @Test
    fun `쉼표 구분 테스트`() {
        assertThatThrownBy { Racers("pobi crong honux") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 쉼표(,)로 구분해 주세요.")
    }

    @DisplayName("입력된 자동차 이름이 중복인 경우 예외처리")
    @Test
    fun `입력된 자동차 이름이 중복인 경우`() {
        assertThatThrownBy { Racers("pobi,crong,honux,pobi") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("자동차 이름은 중복될 수 없습니다.")
    }
}
