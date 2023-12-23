fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""
    
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()
    
    println("Slug gerado para o livro:")
    println("${slugTitulo.trimStart('_')}$slugAutor")
}

fun String.generateSlug(): String {
    val normalizedString = this
        .toLowerCase()
        .replace("[^a-z0-9\\s-]".toRegex(), "") 
        .replace("\\s+".toRegex(), "-") 
        .trimStart()
        
    val slugWithoutLeadingUnderscore = if (normalizedString.isNotBlank() && normalizedString.startsWith("_")) {
        normalizedString.substring(1)
    } else {
        normalizedString
    }

    return if (normalizedString.isNotBlank()) "_$normalizedString" else ""
}
