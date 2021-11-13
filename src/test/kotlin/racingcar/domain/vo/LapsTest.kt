package racingcar.domain.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("레이스 콜렉션(Laps)")
class LapsTest {
    @Test
    fun `라운드만큼 레이스를 생성한다`() {
        val expected = arrayOf(Lap.of(1), Lap.of(2), Lap.of(3))
        assertAll(
            { assertThat(Laps.of("3").toList()).containsExactly(*expected) },
            { assertThat(Laps.of(3).toList()).containsExactly(*expected) }
        )
    }

    @Test
    fun `라운드가 1보다 작은 경우 예외를 발생한다`() {
        assertThatThrownBy { Laps.of(0) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("한 바퀴 이상 경주해야 합니다.")
    }

    @Test
    fun `레이스 Set으로 생성하는 경우 오름차순으로 조정된다`() {
        val expected = arrayOf(Lap.of(1), Lap.of(2), Lap.of(3))
        assertThat(
            Laps.of(
                setOf(Lap.of(2), Lap.of(3), Lap.of(1))
            ).toList()
        ).containsExactly(*expected)
    }

    @Test
    fun `마지막 레이스를 가져온다`() {
        val lastLap = Laps.of(3).last()
        val expected = Lap.of(3)
        assertThat(lastLap).isEqualTo(expected)
    }
}
