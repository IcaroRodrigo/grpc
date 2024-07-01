# Use a imagem base do Kali Linux
FROM kalilinux/kali-rolling

# Atualizar o sistema e instalar ferramentas básicas de cibersegurança
RUN apt-get update && apt-get upgrade -y && \
    apt-get install -y kali-linux-default && \
    apt-get clean

# Instalar outras ferramentas que você possa precisar
RUN apt-get update && apt-get install -y \
    net-tools \
    curl \
    wget \
    vim \
    git \
    nmap \
    metasploit-framework \
    john \
    hydra \
    nikto \
    sqlmap \
    && apt-get clean

# Adicionar um usuário não root (opcional)
#RUN useradd -m kaliuser && echo "kaliuser:kali" | chpasswd && adduser kaliuser sudo

# Definir o usuário padrão para não root
#USER kaliuser

# Definir o diretório de trabalho
#WORKDIR /home/kaliuser

# Iniciar um shell por padrão
CMD ["/bin/bash"]
