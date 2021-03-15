FROM library/postgres
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD root
ENV POSTGRES_DB manager
EXPOSE 5433

# docker build -t manager .
# docker run --rm --name test -p 5433:5432 manager