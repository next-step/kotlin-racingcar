package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TrialOrderTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 48, 203802, Int.MAX_VALUE])
    fun `시도 순서(TrialOrder)의 값을 조회하면 생성 시 입력한 값을 그대로 가지고 있다`(value: Int) {
        assertThat(TrialOrder(value).value).isEqualTo(value)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 48, 203802, Int.MAX_VALUE])
    fun `TrialOrder는 객체가 달라도 값이 같으면 동일하다`(value: Int) {
        assertThat(TrialOrder(value)).isEqualTo(TrialOrder(value))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -278, -2042, Int.MIN_VALUE])
    fun `1부터 순서대로 생성되는 시도 순서는, 양수가 아니면 IllegalArgumentException을 던진다`(value: Int) {
        assertThatIllegalArgumentException()
            .isThrownBy { TrialOrder(value) }
            .withMessage("The number must be positive.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 48, 203802, Int.MAX_VALUE])
    fun `0부터 순서대로 생성되는 인덱스 값을 order에 맞게 변환하여 검증한다 (index = order - 1)`(checkingIndex: Int) {
        val orderValue = 10
        assertDoesNotThrow { TrialOrder(orderValue).checkOrder(orderValue - 1) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 48, 203802, Int.MAX_VALUE])
    fun `인덱스가 순서에 맞지 않으면 IllegalArgumentException을 반환한다`(checkingIndex: Int) {
        val orderValue = 10
        assertThatIllegalArgumentException()
            .isThrownBy { TrialOrder(orderValue).checkOrder(checkingIndex) }
            .withMessage("The results of racing is not ordered. trialOrder='$orderValue', givenIndex=$checkingIndex")
    }
}
