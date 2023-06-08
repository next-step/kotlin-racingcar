package com.racing.step2

private val OPERATION_LIST = listOf<String>("+", "-", "*", "/")

fun checkExpressionFormat(expressionList: List<String>) {
    if (expressionList.size <= 2 || expressionList.size % 2 == 0) {
        throw IllegalArgumentException("식을 정확하게 입력해주세요")
    }
}

fun checkExpressionOperateIndex(expressionList: List<String>) {
    for (index in expressionList.indices) {
        if (index % 2 != 0)
            if (!OPERATION_LIST.contains(expressionList[index])) {
                throw IllegalArgumentException("식을 정확하게 입력해주세요")
            }
    }
}
