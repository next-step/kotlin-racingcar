package domain.step3.domain.racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class DistanceDrivenTest {

    @DisplayName("Distance 인스턴스 생성시 범위 실패 테스트")
    @ParameterizedTest()
    @ValueSource(ints = [-100, -10, -1])
    fun constructor_test(distanceDrivenInt: Int) {
        assertThatThrownBy { DistanceDriven(distanceDrivenInt) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("DistanceDriven 가 허용하는 범위 밖의 숫자가 입력 되었습니다.")
    }
}
