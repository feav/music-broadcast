# Stage 1: Builder
FROM node:20.11.0 AS builder

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install -g npm@10.4.0

RUN npm install

COPY . .

RUN npm run build --prod

CMD ["node", "./dist/music-reader/server/server.mjs"]
