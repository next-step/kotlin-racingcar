package racingcar.ui

class NameInputParser : InputParser<List<String>> {
    override fun parse(input: String): List<String> {
        return input.split(",").map {
            validate(it.trim())
        }
    }

    private fun validate(name: String): String {
        require(name.length <= NAME_MAX_LENGTH && name.isNotEmpty()) {
            "이름은 1 ~ 5 글자 사이여야 합니다"
        }
        return name
    }

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}
