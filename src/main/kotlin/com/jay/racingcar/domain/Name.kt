package com.jay.racingcar.domain

@JvmInline
value class Name(val value: String) {
    init {
        require(value.length <= MAX_NAME_LENGTH) { "이름은 5글자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
