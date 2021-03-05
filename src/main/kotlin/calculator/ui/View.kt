package calculator.ui

import java.io.InputStream
import java.util.Scanner

fun inputExpression(input: InputStream): String {
    print("계산식을 입력해주세요 : ")
    return Scanner(input).nextLine()
}
