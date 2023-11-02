package step4.domain

interface ResultView<in T> {
    fun showResult(resultInfo: T)
}
