package util.racing.converter

import domain.racing.Name

object NameInputConverter {
    private const val DELIMITER = ","

    fun converter(nameInput: String): List<Name> {
        return nameInput.split(DELIMITER)
            .map { Name(it) }
            .toList()
    }
}
