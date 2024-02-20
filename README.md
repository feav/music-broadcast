  
---

# Projet Music

![Illustration](https://i.imgur.com/BPMPhGB.png)

Ce projet contient plusieurs modules pour le développement, le déploiement et la distribution d'une application de lecture de musique.
 

## distribution
Ce répertoire contient le code source de l'application backend.
http://194.164.17.197:9091/api/v1/productions/

![Illustration](https://imgur.com/iIFY647.png)

### Structure du répertoire :
- **.mvn/** : Fichiers de configuration Maven.
- **src/** : Code source de l'application backend.
  - **main/**
    - **java/** : Code Java de l'application.
    - **resources/** : Ressources de l'application.
  - **test/**
    - **java/** : Tests unitaires Java.

Les containers lancés dans ce contexte pour faire tourner le backend.

![Illustration](https://imgur.com/C1EIhVF.png)

## music-reader
Ce répertoire contient le code source de la deuxième version du lecteur de musique.
http://194.164.17.197/home 
 
![Illustration](https://imgur.com/kPCg1mr.png)

### Structure du répertoire :
- **.angular/** : Cache Angular.
- **src/** : Code source de l'application frontend.
  - **app/** : Code Angular de l'application.
  - **assets/** : Fichiers statiques de l'application.

## jenkins
Ce répertoire contient les fichiers Jenkins pour l'intégration continue.

![Illustration](https://imgur.com/1bCMFhv.png)

#### **music-distribution/** : Fichiers Jenkins pour le déploiement de l'application.

![Illustration](https://imgur.com/SN2wKfj.png)
#### **music-reader/** : Fichiers Jenkins pour le déploiement du lecteur de musique.

![Illustration](https://imgur.com/u5lkUuG.png)

Déploiement des images sur Docker Hub
![Illustration](https://imgur.com/HR55V7x.png)

## ansible
Ce répertoire contient les scripts Ansible pour le déploiement de l'application.

![Illustration](https://imgur.com/ixSe9m2.png) 

### Contenu : 
- **music-distribution.yml** : Script Ansible pour le déploiement du backend et du frontend de l'application.
- **music-reader.yml** : Script Ansible pour le déploiement du lecteur de musique.

---
