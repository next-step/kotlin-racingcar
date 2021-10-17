package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

@Suppress("NonAsciiCharacters")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class OperatorFactoryTest {

    @ParameterizedTest
    @MethodSource
    fun `연산자 리터럴에 알맞은 연산자 오브젝트 반환`(arg: OperatorArg) {
        assertThat(OperatorFactory.getBinaryFor(arg.literal)).isEqualTo(arg.result)
    }

    @Test
    fun `지원하지 않는 연산자일 경우 예외`() {
        assertThatThrownBy {
            OperatorFactory.getBinaryFor("%")
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("%은 지원하는 연산자가 아닙니다.")
    }

    @Suppress("unused")
    private fun `연산자 리터럴에 알맞은 연산자 오브젝트 반환`(): List<OperatorArg> {
        return listOf(
            OperatorArg("+", Plus),
            OperatorArg("-", Minus),
            OperatorArg("*", Multiply),
            OperatorArg("/", Divide)
        )
    }

    data class OperatorArg(
        val literal: String,
        val result: BinaryOperator,
    )
}
