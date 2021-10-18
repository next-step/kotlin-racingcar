package racingcar.domain

import racingcar.splitText

data class Names(val names: Set<Name>) {

    companion object {
        private const val DELIMITER = ","

        fun generateNames(text: String): Names {
            val splitText = splitText(text, DELIMITER)
            return Names(splitText.map { Name(it) }.toSet())
        }
    }
}
