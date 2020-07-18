#bash
docker run -d --name postgres -v "$(pwd)"/setup-postgre.sql:/home/setup-postgre.sql -e POSTGRES_PASSWORD=admin -e POSTGRES_USER=admin -e POSTGRES_DB=postgres -p 5432:5432  postgres
sleep 3
docker exec -it postgres psql -U admin -d postgres -f /home/setup-postgre.sql