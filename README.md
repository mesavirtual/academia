# API - Gestão de Academia

## 1. Aluno

### Listar
* GET http://localhost:8080/alunos

#### Response
```
[{"id":1,"nome":"João Silva","cpf":"123.456.789-00","dataNascimento":"1990-05-15","endereco":"Rua A, 123","telefone":"(11) 9999-8888","treinos":[{"id":1,"descricao":"Treino de musculação para iniciantes","dataInicio":"2023-10-01","dataFim":"2023-12-31","alunoId":null,"professorId":null}]},{"id":3,"nome":"Carlos da Costa","cpf":"123.456.788-00","dataNascimento":"1989-06-15","endereco":"Rua A, Blabla","telefone":"(11) 9999-8898","treinos":[]},{"id":6,"nome":"Pedro Segundo","cpf":"123.456.788-77","dataNascimento":"1999-06-01","endereco":"Rua A, Blablahia","telefone":"(11) 9999-8893","treinos":[]},{"id":7,"nome":"Pedro Terceiro","cpf":"123.456.788-88","dataNascimento":"1999-06-01","endereco":"Rua A, Blablahia","telefone":"(11) 9999-8893","treinos":[{"id":4,"descricao":"Treino de musculação para iniciantes","dataInicio":"2023-10-01","dataFim":"2023-12-31","alunoId":null,"professorId":null}]}]
```

### Consultar aluno
* GET http://localhost:8080/alunos/1

#### Response
```
{"id":7,"nome":"Pedro Terceiro","cpf":"123.456.788-88","dataNascimento":"1999-06-01","endereco":"Rua A, Blablahia","telefone":"(11) 9999-8893","treinos":[{"id":4,"descricao":"Treino de musculação para iniciantes","dataInicio":"2023-10-01","dataFim":"2023-12-31","alunoId":null,"professorId":null}]}
```
### Cadastrar aluno
* POST http://localhost:8080/alunos

#### Body
```
{
    "nome": "Pedro Terceiro",
    "cpf": "123.456.788-88",
    "dataNascimento": "1999-06-01",
    "endereco": "Rua A, Blablahia",
    "telefone": "(11) 9999-8893"
}
```

#### Response
```
{"id":7,"nome":"Pedro Terceiro","cpf":"123.456.788-88","dataNascimento":"1999-06-01","endereco":"Rua A, Blablahia","telefone":"(11) 9999-8893","treinos":null,"fichaAcompanhamento":null}
```

## 2. Professor