package br.senai.sp.escolamvc.repository;

import br.senai.sp.escolamvc.model.Aluno;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno , Long> {
    List<Aluno> findAlunosByNomeContaining(String nome);

    Aluno findAlunoByCpf(@CPF(message = "CPF inválido!") @NotEmpty(message = "O campo CPF deve ser preenchido") String cpf);

    Aluno findAlunosByNomeContainingOrCpfContaining(String nome, @CPF(message = "CPF inválido!") @NotEmpty(message = "O campo CPF deve ser preenchido") String cpf);
}
