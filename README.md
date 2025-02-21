# API - Gestão de Academia

## 1. Aluno

### Listar
* GET http://localhost:8080/alunos

#### Response
```
[
    {
        "id": 1,
        "nome": "João Silva",
        "cpf": "123.456.789-00",
        "dataNascimento": "1990-05-15",
        "endereco": "Rua A, 123",
        "telefone": "(11) 9999-8888",
        "treinos": [
            {
                "id": 1,
                "descricao": "Treino de musculação para iniciantes",
                "dataInicio": "2023-10-01",
                "dataFim": "2023-12-31",
                "alunoId": null,
                "professorId": null
            }
        ]
    },
    {
        "id": 7,
        "nome": "Pedro Terceiro",
        "cpf": "123.456.788-88",
        "dataNascimento": "1999-06-01",
        "endereco": "Rua A, Blablahia",
        "telefone": "(11) 9999-8893",
        "treinos": [
            {
                "id": 4,
                "descricao": "Treino de musculação para iniciantes",
                "dataInicio": "2023-10-01",
                "dataFim": "2023-12-31",
                "alunoId": null,
                "professorId": null
            }
        ]
    }
]
```

### Consultar aluno
* GET http://localhost:8080/alunos/1

#### Response
```
{
    "id": 7,
    "nome": "Pedro Terceiro",
    "cpf": "123.456.788-88",
    "dataNascimento": "1999-06-01",
    "endereco": "Rua A, Blablahia",
    "telefone": "(11) 9999-8893",
    "treinos": [
        {
            "id": 4,
            "descricao": "Treino de musculação para iniciantes",
            "dataInicio": "2023-10-01",
            "dataFim": "2023-12-31",
            "alunoId": null,
            "professorId": null
        }
    ]
}
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

## 3. Treino

### Cadastrar treino
* POST http://localhost:8080/treinos

#### Body
```
{
    "descricao": "Treino de musculação para iniciantes",
    "dataInicio": "2023-10-01",
    "dataFim": "2023-12-31",
    "alunoId": 7,
    "professorId": 1
}
```

#### Response
```
{
    "id": 4,
    "descricao": "Treino de musculação para iniciantes",
    "dataInicio": "2023-10-01",
    "dataFim": "2023-12-31",
    "alunoId": 7,
    "professorId": 1
}
```