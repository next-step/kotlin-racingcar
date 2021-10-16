package domain.step2.strategy.split

class SingleBlankSplitStrategy : SplitStrategy {

    override fun split(target: String) = target.split(SINGLE_BLANK)

    companion object {
        private const val SINGLE_BLANK = " "
    }
}
