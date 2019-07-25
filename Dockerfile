FROM abazovic/fs-vanilla
RUN apt-get install -y default-jdk
COPY . /tmp
WORKDIR /tmp
CMD ["./docker-entrypoint.sh"]