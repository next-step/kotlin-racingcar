package global.strategy.split

object SingleBlankSplitStrategy : SplitStrategy {

    private const val SINGLE_BLANK = " "
    override fun split(target: String): List<String>  = target.split(SINGLE_BLANK)

}
