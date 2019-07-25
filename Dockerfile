FROM debian:9
RUN apt-get update && apt-get install -y gnupg2 wget default-jdk && \
wget -O - https://files.freeswitch.org/repo/deb/freeswitch-1.8/fsstretch-archive-keyring.asc | apt-key add - && \
echo "deb http://files.freeswitch.org/repo/deb/freeswitch-1.8/ stretch main" > /etc/apt/sources.list.d/freeswitch.list && \
echo "deb-src http://files.freeswitch.org/repo/deb/freeswitch-1.8/ stretch main" >> /etc/apt/sources.list.d/freeswitch.list && \
# the vanilla configuration for freeswitch is deployed 
apt-get update && apt-get install -y freeswitch-meta-all
COPY . /tmp
WORKDIR /tmp
CMD ["./docker-entrypoint.sh"]