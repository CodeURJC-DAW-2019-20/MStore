docker run --rm -v {{path}}:/usr/src/project -w /usr/src/project maven:alpine mvn package

cd ..

docker buid -t appjar -f docker/Dockerfile .

