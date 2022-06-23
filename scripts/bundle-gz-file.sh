#!/bin/env sh
if [ -f ".temp" ]; then
  rm -r ./.temp/
fi

mkdir ./.temp/
cp ../out/artifacts/jpwd_jar ./.temp/
cp ./jpwd.sh ./.temp/


cp ../out/artifacts/jpwd_jar .
cp ./jpwd.sh .

cd ./.temp || echo "Error: cd ./.temp" && exit 1

ls

VER="$1"
echo "Create tar file to jpwd $VER ..."
TARNAME=jpwd-"$VER".tar.gz
tar -cvf "./$TARNAME" ./jpwd.sh ./jpwd.jar

cd ../..
if ! [ -f "./release" ]; then
  echo "Create release file"
  mkdir release 
fi

echo "Move the $TARNAME to release directory."

mv "./scripts/.temp/$TARNAME" ./release

echo "Remove temp folder"
rm -r ./scripts/.temp
