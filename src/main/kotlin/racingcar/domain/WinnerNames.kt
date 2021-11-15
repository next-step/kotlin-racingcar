package racingcar.domain

object WinnerNames {
    fun combineWinnerNames(names: List<String>): String {
        return names.joinToString {
            it
        }
    }
}
