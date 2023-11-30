enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        if (!inscritos.contains(usuario)) {
            inscritos.add(usuario)
            println("${usuario.nome} matriculado na formação $nome.")
        } else {
            println("${usuario.nome} já está matriculado nesta formação.")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos = conteudos + conteudo
        println("Conteúdo ${conteudo.nome} adicionado à formação $nome.")
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
    val formacao1 = Formacao("Desenvolvedor Kotlin", Nivel.BASICO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Android Developer", Nivel.INTERMEDIARIO, listOf(conteudo2, conteudo3))

    // Matrícula de usuários em formações
    formacao1.matricular(usuario1)
    formacao1.matricular(usuario2)
    formacao2.matricular(usuario1)

    // Tentativa de matrícula repetida
    formacao1.matricular(usuario1)

    // Adição de conteúdo à formação
    val conteudo4 = ConteudoEducacional("Testes em Kotlin")
    formacao1.adicionarConteudo(conteudo4)

    // Impressão de inscritos e conteúdos
    println("Inscritos na formação ${formacao1.nome}: ${formacao1.inscritos.map { it.nome }}")
    println("Conteúdos na formação ${formacao1.nome}: ${formacao1.conteudos.map { it.nome }}")
    println("Inscritos na formação ${formacao2.nome}: ${formacao2.inscritos.map { it.nome }}")
    println("Conteúdos na formação ${formacao2.nome}: ${formacao2.conteudos.map { it.nome }}")
}
