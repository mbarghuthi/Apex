FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y \
      git \
      maven \
      default-jdk \
      chromium \
      chromium-driver \
      fonts-liberation \
      libasound2t64 \
      libatk-bridge2.0-0 \
      libatk1.0-0 \
      libcups2t64 \
      libdbus-1-3 \
      libdrm2 \
      libgbm1 \
      libgtk-3-0 \
      libnspr4 \
      libnss3 \
      libu2f-udev \
      libvulkan1 \
      libxcomposite1 \
      libxdamage1 \
      libxfixes3 \
      libxkbcommon0 \
      libxrandr2 \
      xdg-utils && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/lib/jvm/default-java
ENV PATH=$JAVA_HOME/bin:/usr/share/maven/bin:/usr/bin:$PATH

USER jenkins