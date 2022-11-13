package com.jay.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

internal class NameTest {
    @ParameterizedTest
    @MethodSource("nameInputs")
    fun `이름이 정상길이로 초기화된다`(input: String) {
        val name = Name(input)

        assertThat(name.value).isEqualTo(input)
    }

    @ParameterizedTest
    @MethodSource("malformedNameInputs")
    fun `5자를 초과하는 이름은 생성되지 못한다`(input: String) {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Name(input)
        }

        assertThat(exception.message).isEqualTo("이름은 5글자를 초과할 수 없습니다.")
    }

    companion object {
        @JvmStatic
        fun malformedNameInputs() = listOf(
            Arguments.of("jayyyy"),
            Arguments.of("ddddddddddddddd")
        )

        @JvmStatic
        fun nameInputs() = listOf(
            Arguments.of("j"),
            Arguments.of("ja"),
            Arguments.of("jay"),
            Arguments.of("jayy"),
            Arguments.of("jayyy")
        )
    }
}
