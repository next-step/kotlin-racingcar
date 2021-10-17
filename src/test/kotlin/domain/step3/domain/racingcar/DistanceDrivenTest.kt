package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DistanceDrivenTest {

    @ParameterizedTest(name = "이동 거리 값 : {0}")
    @ValueSource(ints = [-100, -10, -1, 0])
    fun `음수가 입력되면 주행거리 생성이 실패한다`(distanceDrivenInt: Int) {
        assertThatThrownBy { DistanceDriven(distanceDrivenInt) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }

    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(ints = [1, 10, 100])
    fun `주행거리가 동일하다면 같은 객체이다`(distanceDrivenInt: Int) {
        val one = DistanceDriven(distanceDrivenInt)
        val other = DistanceDriven(distanceDrivenInt)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) },
        )
    }

    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(ints = [1, 10, 100])
    fun `주행거리에 대한 정수형 값을 반환한다`(distanceDrivenInt: Int) {
        val distanceDriven = DistanceDriven(distanceDrivenInt)

        assertAll(
            { assertThat(distanceDriven.distanceDriven).hasSameHashCodeAs(distanceDrivenInt) },
            { assertThat(distanceDriven.distanceDriven).isEqualTo(distanceDrivenInt) },
        )
    }

    @Test
    fun `기본 주행거리 값은 1로 시작된다`() {
        val distanceDriven = DistanceDriven()
        assertAll(
            { assertThat(distanceDriven.distanceDriven).isNotNull() },
            { assertThat(distanceDriven.distanceDriven).isEqualTo(1) },
        )
    }

    @Test
    fun `주행거리는 1칸 이동한다`() {
        // given
        val distanceDriven = DistanceDriven()

        // when
        val movedDistanceDriven = distanceDriven.moveForward()

        // then
        assertAll(
            { assertThat(movedDistanceDriven).isNotNull() },
            { assertThat(movedDistanceDriven.distanceDriven).isEqualTo(2) },
        )
    }
}
