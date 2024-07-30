# Getting Started

### Инструкция по запуске

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
