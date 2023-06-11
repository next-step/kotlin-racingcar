package step3.view

import step3.domain.RacingRequirement

interface InputView {
    fun askRequirement(): RacingRequirement
}
