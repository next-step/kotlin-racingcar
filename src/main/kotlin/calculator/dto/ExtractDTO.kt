package calculator.dto

data class ExtractDTO(
    val numbers: MutableList<Double>,
    val operators: MutableList<Char>,
)
