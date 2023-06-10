package step3.view

import step3.Distance

interface OutputView {
    fun showResultTitle()
    fun showStatus(distanceResult: List<Distance>)
}
