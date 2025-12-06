public class Aluno extends Usuario implements Autenticacao, Relatorio {
    private String matricula;
    private String curso;

    public Aluno(String nome, String login, String senha, String matricula, String curso) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return getLogin().equals(login) && getSenha().equals(senha);
    }

    @Override
    public String gerarRelatorio() {
        return "Relatório do Aluno:\n" +
               " - Nome: " + getNome() + "\n" +
               " - Matrícula: " + getMatricula() + "\n" +
               " - Curso: " + getCurso();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
               "nome='" + getNome() + '\'' +
               ", matricula='" + matricula + '\'' +
               ", curso='" + curso + '\'' +
               '}';
    }
}