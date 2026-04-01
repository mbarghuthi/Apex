FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y git maven default-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/default-java
ENV PATH=$JAVA_HOME/bin:/usr/share/maven/bin:$PATH

USER jenkins