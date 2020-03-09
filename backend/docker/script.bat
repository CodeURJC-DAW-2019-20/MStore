docker run --rm -v {{path}}:/usr/src/project -w /usr/src/project maven:alpine mvn package

cd ..

docker build -t nmartinezs2017/webapp10 -f docker/Dockerfile .

