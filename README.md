# Getting Started

### Инструкция по запуску

1. Выполните команды:

```bash
docker login
docker pull 2admi/minimal-service:latest
docker run -p 8000:8000 2admi/minimal-service:latest
```

2. Откройте браузер и перейдите по адресу http://localhost:8000/health.
3. Вы должны увидеть следующий ответ:

```json
{
  "status": "OK"
}
```

### Инструкция по запуску в кластере Kubernetes

1. Установить кластер Kubernetes и Helm.
2. Выполните команды:

```bash
cd src/main/resources
helm install user-service-chart-release user-service-chart    
```

2. Выполните HTTP-запросы из Postman-коллекции в файле [src/main/resources/static/user-service.postman_collection.json](src/main/resources/static/user-service.postman_collection.json)
3. Вы должны увидеть следующий ответ:

```
→ Health Check
GET http://arch.homework/health [200 OK, 155B, 277ms]

→ Create user
POST http://arch.homework/api/v1/user [201 Created, 273B, 4.2s]

→ Update user
PUT http://arch.homework/api/v1/user/1 [200 OK, 264B, 4.7s]

→ Get user
GET http://arch.homework/api/v1/user/1 [200 OK, 264B, 68ms]

→ Delete user
DELETE http://arch.homework/api/v1/user/1 [204 No Content, 88B, 71ms]
```
