import jdk.nashorn.internal.objects.Global.print

class main {
    fun main(): List<String> {
        var str = "Kotlin TutorialsepTutorial KartsepExamples"
        var delimiter = "sep"
        val parts = str.split(" ")
        println(parts)
        return parts
    }
}