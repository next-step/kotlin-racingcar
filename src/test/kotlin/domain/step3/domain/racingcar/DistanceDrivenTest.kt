package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DistanceDrivenTest {

    @DisplayName("Distance 인스턴스 생성시 범위 실패 테스트")
    @ParameterizedTest(name = "실패될 주입 값 : {0}")
    @ValueSource(ints = [-100, -10, -1])
    fun constructor_test(distanceDrivenInt: Int) {
        assertThatThrownBy { DistanceDriven(distanceDrivenInt) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }

    @DisplayName("Distance 인스턴스 hashCode 및 equals 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(ints = [0, 1, 10, 100])
    fun hasCode_and_equals_test(distanceDrivenInt: Int) {
        val one = DistanceDriven(distanceDrivenInt)
        val other = DistanceDriven(distanceDrivenInt)

        assertAll(
            { assertThat(one).hasSameHashCodeAs(other) },
            { assertThat(one).isEqualTo(other) },
        )
    }

    @DisplayName("Distance 인스턴스 getter 테스트")
    @ParameterizedTest(name = "주입 값 : {0}")
    @ValueSource(ints = [0, 1, 10, 100])
    fun getter_test(distanceDrivenInt: Int) {
        val distanceDriven = DistanceDriven(distanceDrivenInt)

        assertAll(
            { assertThat(distanceDriven.distanceDriven).hasSameHashCodeAs(distanceDrivenInt) },
            { assertThat(distanceDriven.distanceDriven).isEqualTo(distanceDrivenInt) },
        )
    }
}
