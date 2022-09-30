##Tecnologias utilizadas

### Java 8
### Spring Boot 2.7.1
### Lombok
### Spring Data JPA
### DB Mysql
### Apache Poi
### Spring Framework
### Maven

#### Ponto

##### GET /pontos/{id}: - Buscar um ponto específico por id

##### GET /pontos/pontos: - Listar todos os pontos

##### GET /pontos/por-id-e-tempo: - Buscar um ponto específico por id e timestamp
##### KEYS: pontoId, ts; VALUES: Long, String; 

##### POST /pontos/uploadPontos: - Adicionar pontos de um arquivo xlsx
##### KEYS: file; VALUES: Anexar o arquivo;


#### Dado

##### GET /dados/dados: - Listar todos os dados

##### POST /dados/uploadDados: - Adicionar dados de um arquivo xlsx
##### KEYS: file; VALUES: Anexar o arquivo;
