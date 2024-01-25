#!/bin/bash

# Install Docker and Docker Compose on the remote server if not already installed
ssh root@85.215.237.144 'bash -s' < /path/on/remote/server/install-docker.sh

# Run Ansible playbook
ansible-playbook -i /path/on/remote/server/hosts /path/on/remote/server/deploy.yml
