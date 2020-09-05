## Account Service

## Docker
Redis
```
docker run -p 6379:6379 --name myredis -v myredis-data:/data -d redis:6.0.6-alpine
```

PostgreSQL
```
docker run -p 5434:5434 --name mypostgres -v mypg-data:/var/lib/postgresql/data -e POSTGRES_PASSWORD=rahasia1234 -d postgres:11-alpine
```