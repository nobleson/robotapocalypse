# build stage
FROM node:12.14-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN apk add --no-cache python3 g++ make
RUN npm install -g http-server
RUN npm install
COPY . .
RUN npm run build
EXPOSE 3000
CMD [ "http-server", "dist" ]