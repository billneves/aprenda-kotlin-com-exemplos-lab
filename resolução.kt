enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado nesta formação.")
        }
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("Alice")
    val usuario2 = Usuario("Bob")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 45)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos", 60)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Android", 90)

    // Criação de formações
    val formacao1 = Formacao("Desenvolvedor Kotlin", listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Android Developer", listOf(conteudo2, conteudo3))

    // Matrícula de usuários em formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario1)

    // Tentativa de matrícula repetida
    formacao1.matricular(usuario1)

    // Impressão de inscritos
    println("Inscritos na formação ${formacao1.nome}: ${formacao1.inscritos.map { it.nome }}")
    println("Inscritos na formação ${formacao2.nome}: ${formacao2.inscritos.map { it.nome }}")
}
