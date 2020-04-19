docker run --rm --name angular -v {path}/MStore/frontend:/frontend -w /frontend node /bin/bash -c "npm install -g @angular/cli; npm install --no-bin-links; ng build --prod --base-href /new/"

docker run --rm -v {path}/MStore:/usr/src/proyect -w /usr/src/proyect/backend maven:alpine mvn package

cd ..

docker build -t nmartinezs2017/webapp10 -f docker/Dockerfile .

