💰 API de Controle de Finanças Pessoais

🧩 Sobre o Projeto                      
API desenvolvida em Java 17+ com Spring Boot 3 para gerenciamento de usuários, categorias e despesas.
O objetivo é permitir o controle financeiro pessoal, com cadastro e organização de despesas por categoria.

⚙️ Tecnologias Utilizadas                                 
Java 17+                 
Spring Boot 3 (Web, JPA, Validation)          
H2 Database (banco em memória/local)                
Lombok                 
Maven                  
Postman para testes de API                   

🗂️ Estrutura do Projeto
src/main/java/com/example/Trab_Final/                                                             
│                                                                                                                                                
├── controller/        → Controladores REST                          
├── service/           → Regras de negócio                      
├── dto/               → Objetos de transferência de dados                          
├── model/             → Entidades JPA                                 
├── repository/        → Interfaces de persistência                           
├── exception/         → Exceções personalizadas e GlobalHandler                                
└── TrabFinalApplication.java  → Classe principal                                  

🚀 Como Executar o Projeto                    
Pré-requisitos             
Java JDK 17 ou superior                    
Maven instalado             
IntelliJ IDEA ou VSCode com extensão Java                      

Passos:       
Clone o repositório:                     
  git clone https://github.com/seu-usuario/controle-financas.git                    
Acesse o diretório do projeto:              
  cd controle-financas            
Execute o projeto:           
  mvn spring-boot:run             
Acesse a API em:              
  http://localhost:8080                             
                    
🧠 Endpoints Principais            
        
👤 Usuários                  
POST /usuarios                      
{                      
  "nome": "Rafael Pagnan",                     
  "email": "rafael@email.com",                    
  "senha": "123456"           
}          
GET /usuarios → Lista todos os usuários                      
GET /usuarios/{id} → Busca um usuário pelo ID            
PUT /usuarios/{id} → Atualiza dados de um usuário           
DELETE /usuarios/{id} → Remove um usuário            
             
🏷️ Categorias             
POST /categorias
{           
  "nome": "Alimentação",                   
  "descricao": "Gastos com alimentação e restaurantes"           
}
GET /categorias → Lista todas as categorias          
GET /categorias/{id} → Busca uma categoria pelo ID            
PUT /categorias/{id} → Atualiza informações da categoria                     
DELETE /categorias/{id} → Remove uma categoria          
           
💸 Transações            
POST /transacoes         
{          
  "descricao": "Jantar no restaurante",                                    
  "valor": 120.50,         
  "data": "2025-11-08",        
  "usuarioId": 1,             
  "categoriaId": 2            
}          

GET /transacoes → Lista todas as despesas                    
GET /transacoes/{id} → Busca uma despesa pelo ID            
PUT /transacoes/{id} → Atualiza informações de uma despesa           
DELETE /transacoes/{id} → Remove uma despesa       
        
⚠️ Possíveis Erros                            
Código	Causa	Solução                     
400	Dados inválidos	Verifique os campos obrigatórios
404	Recurso não encontrado	O ID informado pode não existir               
415	Content-Type incorreto	Use application/json no Postman                    
500	Erro interno	Confira se há problemas no banco H2            
🧰 Banco de Dados H2         

Acesse o console do banco via navegador:            
http://localhost:8080/h2-console                             
        
Configuração:           
JDBC URL: jdbc:h2:file:./cadastro          
User:               
Password:     

👨‍💻 Autor           
Rafael Marques Pagnan             
Joao Vitor Pereira Freitas         
