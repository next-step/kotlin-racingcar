package calculator.util

val regexForNumberAndOperator = """^[0-9+\-*/\s]+$""".toRegex()
val regexForNumber = """\d+""".toRegex()
val regexForOperator = """[+\-*/]""".toRegex()
