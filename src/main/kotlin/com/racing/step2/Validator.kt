package com.racing.step2

fun checkExpressionFormat(expressionList: List<String>) {
    if (expressionList.size <= 2 || expressionList.size % 2 == 0) {
        throw IllegalArgumentException("식을 정확하게 입력해주세요")
    }
}
