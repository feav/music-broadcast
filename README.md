
---

# Projet Music

![Illustration](https://i.imgur.com/BPMPhGB.png)

Ce projet contient plusieurs modules pour le développement, le déploiement et la distribution d'une application de lecture de musique.

## ansible
Ce répertoire contient les scripts Ansible pour le déploiement de l'application.

### Contenu :
- **music-distribution.yml** : Script Ansible pour le déploiement du backend et du frontend de l'application.
- **music-reader.yml** : Script Ansible pour le déploiement du lecteur de musique.

## distribution
Ce répertoire contient le code source de l'application backend.

### Structure du répertoire :
- **.mvn/** : Fichiers de configuration Maven.
- **src/** : Code source de l'application backend.
  - **main/**
    - **java/** : Code Java de l'application.
    - **resources/** : Ressources de l'application.
  - **test/**
    - **java/** : Tests unitaires Java.

## jenkins
Ce répertoire contient les fichiers Jenkins pour l'intégration continue.

#### **music-distribution/** : Fichiers Jenkins pour le déploiement de l'application.

![Illustration](https://imgur.com/SN2wKfj.png)
#### **music-reader/** : Fichiers Jenkins pour le déploiement du lecteur de musique.

![Illustration](https://imgur.com/u5lkUuG.png)

## music-reader
Ce répertoire contient le code source de la deuxième version du lecteur de musique.

### Structure du répertoire :
- **.angular/** : Cache Angular.
- **src/** : Code source de l'application frontend.
  - **app/** : Code Angular de l'application.
  - **assets/** : Fichiers statiques de l'application.
---
