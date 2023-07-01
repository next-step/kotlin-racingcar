package racingcar.domain

class NameParser {
    fun parse(names: String): List<String> {
        require(names.isNotBlank()) { "이름은 비어있을 수 없습니다." }
        return names.split(NAME_SPLIT_DELIMITER)
            .map { it.trim() }
    }

    companion object {
        private const val NAME_SPLIT_DELIMITER = ","
    }
}
