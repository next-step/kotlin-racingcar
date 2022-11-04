package nexstep.mission.calculator.io

object InputParser {

    fun parse(input: String): List<String> {
        require(input.isNotBlank()) { "입력값을 제대로 입력해주세요." }
        return input.split(" ")
    }
}
