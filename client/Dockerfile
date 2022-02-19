FROM node:12.14-alpine
RUN apk add --no-cache python3 g++ make
RUN npm install -g http-server
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
EXPOSE 4000
CMD [ "http-server", "dist" ]