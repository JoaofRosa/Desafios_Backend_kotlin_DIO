import kotlin.concurrent.thread
fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    val results = mutableListOf<Pair<Int, Int>>()

    val threadList = mutableListOf<Thread>()

    urls.forEachIndexed { index, url ->
        val t = thread {
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index + 1, length))
            }
        }
        threadList.add(t)
    }

    threadList.forEach { it.join() }

    printResults(results, urls.size)
}

fun printResults(results: List<Pair<Int, Int>>, totalUrls: Int) {
    results.sortedBy { it.first }.forEach { (index, length) ->
        println("Arq$index: $length")
    }
    println("Tempo total: $totalUrls")
}

fun openLink(url: String): Int {
    return url.length
}
