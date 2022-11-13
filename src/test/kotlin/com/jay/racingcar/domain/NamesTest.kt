package com.jay.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

internal class NamesTest {
    @ParameterizedTest
    @MethodSource("malformedNamesInputs")
    fun `이름이 한개라도 5글자를 초과하면 Names는 생성불가하다`(inputs: List<String>) {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Names(inputs)
        }

        Assertions.assertThat(exception.message).isEqualTo("이름은 5글자를 초과할 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource("namesInputs")
    fun `정상적으로 Names가 초기화된다`(inputs: List<String>, size: Int) {
        val name = Names(inputs)

        Assertions.assertThat(name.size()).isEqualTo(size)
    }

    companion object {
        @JvmStatic
        fun malformedNamesInputs() = listOf(
            Arguments.of(listOf("jayyyy")),
            Arguments.of(listOf("ddddddddddddddd")),
            Arguments.of(listOf("jay", "beokbeok"))
        )

        @JvmStatic
        fun namesInputs() = listOf(
            Arguments.of(listOf("jay"), 1),
            Arguments.of(listOf("jay", "beok"), 2),
            Arguments.of(listOf("jay", "honux", "pobi"), 3),
            Arguments.of(listOf("jay", "beok", "pobi", "crox"), 4),
            Arguments.of(listOf("jay", "beok", "pobi", "honux", "crong"), 5)
        )
    }
}
