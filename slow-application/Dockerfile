FROM node:10.14.2-alpine

COPY ./ /usr/src/app

WORKDIR /usr/src/app

RUN yarn install

EXPOSE 3000

CMD ["yarn", "start"]