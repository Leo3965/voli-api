## Voli API

![arquitetura](config/arquitetura-front-back.png)
![autorizacao](config/autorização.png)
![filtro](config/filter.png)
> É um exemplo fictício de backend (API RestFull) para uma instituição médica. Criada com intuito de desenvolver
> conhecimento sobre SpringBoot

### Spring Security

- Autenticação
- Autorização (controle de acesso)
- Proteção contra ataques (CSRF, clickjacking, etc.)

#### Autenticação em aplicação Web **(Statefull)**

> Toda vez que um usuário faz login, a aplicação guarda o estado do usuário atual.
> Criando "sessões" para que o usuário seja identificado nas próximas requisições

#### Autenticação em API Rest **(Stateless)**

> O cliente deve se identificar a cada requisição, não há "sessão/dados" armazenados no
> servidor.