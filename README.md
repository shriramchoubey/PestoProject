# PestoProject
This is sample spring boot project
1. Clone this project
2. Run Mysql from docker-compose.yml file use the command:
   `docker-compose up`

3. Open project in intellij IDE free community edition. https://www.jetbrains.com/idea/download/
4. Create run configuration as shown in image :
5. Use Environment variables
   `MYSQL_URL=mysql://127.0.0.1:3307/pesto;`
   `USERNAME=root;`
   `PASSWORD=123456`
6. Once the project is up and running use this postman collection:
   https://api.postman.com/collections/15114630-5498502d-b607-4a41-aa48-a34052444e53?access_key=PMAT-01HSB7Q28R5AP0KYEYVZVG6MAZ

Import the above collection into your postman and use
1. Create User API to create user.
2. Before any API call you will have to create jwt token using authenticate api and use it into header of every API.